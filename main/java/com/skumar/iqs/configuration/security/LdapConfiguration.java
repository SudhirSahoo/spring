package com.skumar.iqs.configuration.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * Created by vfc01875 on 7/6/2017.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.ldap")
public class LdapConfiguration {
    public static class Group {
        private String searchBase;
        private String searchFilter;

        public String getSearchBase() {
            return searchBase;
        }

        public void setSearchBase(String searchBase) {
            this.searchBase = searchBase;
        }

        public String getSearchFilter() {
            return searchFilter;
        }

        public void setSearchFilter(String searchFilter) {
            this.searchFilter = searchFilter;
        }
    }
    public static class User {
        private String searchBase;
        private String searchFilter;

        public String getSearchBase() {
            return searchBase;
        }

        public void setSearchBase(String searchBase) {
            this.searchBase = searchBase;
        }

        public String getSearchFilter() {
            return searchFilter;
        }

        public void setSearchFilter(String searchFilter) {
            this.searchFilter = searchFilter;
        }
    }
    public static class Roles {
        private String user;
        private String admin;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getAdmin() {
            return admin;
        }

        public void setAdmin(String admin) {
            this.admin = admin;
        }
    }

    private boolean enabled;
    private String urls;
    private String base;
    private String username;
    private String password;
    private Group group;
    private User user;
    private Roles roles;

    @Bean
    public LdapContextSource contextSource(){
        LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl(urls);
        contextSource.setBase(base);
        contextSource.setUserDn(username);
        contextSource.setPassword(password);
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    @Bean
    public LdapContextSource userGroupContextSource(){
        LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl(urls);
        contextSource.setBase(String.join(",", user.getSearchBase(), base));
        contextSource.setUserDn(username);
        contextSource.setPassword(password);
        contextSource.afterPropertiesSet();

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() throws Exception{
        LdapTemplate ldapTemplate = new LdapTemplate();

        ldapTemplate.setIgnorePartialResultException(true);
        ldapTemplate.setContextSource(userGroupContextSource());

        return ldapTemplate;
    }

    //region Getters and Setters

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    //endregion
}

