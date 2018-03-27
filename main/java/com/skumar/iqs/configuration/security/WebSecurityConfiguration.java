package com.skumar.iqs.configuration.security;

import com.skumar.iqs.configuration.ActiveProfilesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vfc01875 on 7/6/2017.
 * This class is used to define the login entry point and ldap authentication.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfiguration.class);
    LdapConfiguration ldapConfig;
    ActiveProfilesConfiguration activeProfiles;
    SecurityUserConfiguration securityUser;
    SimpleAuthenticationSuccessHandler authenticationSuccessHandler;

    public WebSecurityConfiguration(LdapConfiguration ldapConfig,
                                    ActiveProfilesConfiguration activeProfiles,
                                    SecurityUserConfiguration securityUser,
                                    SimpleAuthenticationSuccessHandler authenticationSuccessHandler) {
        this.ldapConfig = ldapConfig;
        this.activeProfiles = activeProfiles;
        this.securityUser = securityUser;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/resources/**", "/assets/**", "/css/**", "/js/**", "/fonts/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // here we define the search paths in the LDAP server
        if (ldapConfig.isEnabled()) {
            log.info("LDAP authentication is enabled.");
            log.info("Configuring LDAP authentication.");

            final LdapConfiguration.Group ldapConfigGroup = ldapConfig.getGroup();
            final LdapConfiguration.User ldapConfigUser = ldapConfig.getUser();
            final LdapConfiguration.Roles ldapConfigRoles = ldapConfig.getRoles();

            auth
                    .ldapAuthentication()
                    .userSearchBase(ldapConfigUser.getSearchBase())
                    .userSearchFilter(ldapConfigUser.getSearchFilter())
                    .groupSearchBase(ldapConfigGroup.getSearchBase())
                    .groupSearchFilter(ldapConfigGroup.getSearchFilter())
                    .contextSource(ldapConfig.contextSource())
                    .ldapAuthoritiesPopulator(new DefaultLdapAuthoritiesPopulator(ldapConfig.contextSource(), ldapConfigGroup.getSearchBase()) {
                        @Override
                        public Set<GrantedAuthority> getGroupMembershipRoles(String userDn, String username) {
                            // ldap automatically adds "ROLE_" before ldap group. Such as "ROLE_IS-HMA" means user is in "IS-HMA" ldap group
                            String rolePrefix = super.getRolePrefix();
                            String adminRole = (rolePrefix + ldapConfigRoles.getAdmin()).toUpperCase();
                            String userRole = (rolePrefix + ldapConfigRoles.getUser()).toUpperCase();

                            // grab all groups of which the current associate is a member
                            Set<GrantedAuthority> groupMembershipRoles = super.getGroupMembershipRoles(userDn, username);

                            // track groups that we need for the application
                            SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(adminRole);
                            SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(userRole);
                            Set<GrantedAuthority> applicationRoles = new HashSet<>();

                            // check if the associate is a member of the admin or user groups and add to application roles set
                            if (groupMembershipRoles.contains(adminAuthority)) applicationRoles.add(adminAuthority);
                            if (groupMembershipRoles.contains(userAuthority)) applicationRoles.add(userAuthority);

                            if (applicationRoles.isEmpty())
                                throw new BadCredentialsException("User must be a member of " + adminRole + " or " + userRole);

                            return applicationRoles;
                        }
                    });
        } else {
            // configure in-memory users that match our test data users
            // do not configure if the PROD profile is active
            log.info("LDAP authentication is disabled.");
            if (!activeProfiles.isProductionProfile()) {
                log.info("Configuring in memory authentication for testing purposes.");
                log.info("User: {}, Password: {}, Roles: {}", this.securityUser.getName(), this.securityUser.getPassword(), this.securityUser.getRole());

                auth.inMemoryAuthentication()
                        .withUser("VFC90315")
                        .password("password")
                        .roles("ADMIN", "USER")
                        .and()
                        .withUser("VFC01875")
                        .password("password")
                        .roles("ADMIN", "USER")
                        .and()
                        .withUser("VFC90844")
                        .password("password")
                        .roles("USER")
                        .and()
                        .withUser(this.securityUser.getName())
                        .password(this.securityUser.getPassword())
                        .roles(this.securityUser.getRole());
            } else {
                log.info("Will not configure in memory authentication for PROD profile.");
            }
        }
    }
}
