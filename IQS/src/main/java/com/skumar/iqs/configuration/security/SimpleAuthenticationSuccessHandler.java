package com.skumar.iqs.configuration.security;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.model.Department;
import com.skumar.iqs.domain.repository.interfaces.AssociateRepository;
import com.skumar.iqs.domain.repository.interfaces.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple extension of the {@link SavedRequestAwareAuthenticationSuccessHandler}
 * class.
 *
 * Following a successful authentication, we pull the necessary
 * associate attributes from LDAP.
 *
 * We then check if the associate exists in the database. If the
 * associate does exist in the database, we compare it against the
 * attributes we pulled from LDAP. We will update the associate in
 * the database if there are any updates available from LDAP.
 *
 * If the associate does not exist in the database, we will simply
 * create a new associate using the LDAP attributes.
 *
 * We also pull the department information from LDAP. If the department
 * does not exist in the database, we will create that department
 * before attempting to create a new associate.
 *
 * @author vfc91343
 * @since 3/22/2018
 */
@Component
public class SimpleAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(SimpleAuthenticationSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    private LdapConfiguration ldapConfiguration;
    private LdapTemplate ldapTemplate;
    private AssociateRepository associateRepository;

    public SimpleAuthenticationSuccessHandler(LdapConfiguration ldapConfiguration,
                                                       LdapTemplate ldapTemplate) {
                                                       //AssociateRepository associateRepository,
                                                       //DepartmentRepository departmentRepository) {
        this.ldapConfiguration = ldapConfiguration;
        this.ldapTemplate = ldapTemplate;
        this.associateRepository = associateRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            String userName;

            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }

           // checkAssociateExists(userName);
        }

        //redirectStrategy.sendRedirect(request, response, "dashboard");
        super.onAuthenticationSuccess(request, response, authentication);
    }

    /*private void checkAssociateExists(String associateNumber) {
        log.info("Checking if associate exists after authentication: {}", associateNumber);

        // get associate details from LDAP
        // create new department/associate in database as needed
        if (this.ldapConfiguration.isEnabled()) {
            ldapTemplate.lookup("cn=" + associateNumber,
                    (AttributesMapper<Associate>) attributes -> {
                        String fullName = String.join(" ", (String) attributes.get("givenName").get(), (String) attributes.get("sn").get());
                        String email = (String) attributes.get("mail").get();
                        String departmentDescription = (String) attributes.get("department").get();
                        // match word boundaries and letter characters (numbers, spaces, etc.) and remove
                        // this will create an acronym out of the department name
                        String departmentName = departmentDescription.replaceAll("\\B.|\\P{L}", "").toUpperCase();

                        Department department = this.departmentRepository.findByName(departmentName);
                        if (department == null)
                            department = this.departmentRepository.create(new Department(departmentName, departmentDescription));

                        // create a new associate object based on LDAP attributes
                        Associate ldapAssociate = new Associate(associateNumber, fullName, email, department);
                        Associate databaseAssociate = this.associateRepository.findByAssociateNumber(associateNumber);

                        if (databaseAssociate != null) {
                            log.info("Associate '{}' already exists in the database");

                            // the associate exists in the database
                            ldapAssociate.setAssociateId(databaseAssociate.getAssociateId());

                            // check for changes and update if necessary
                            if (!databaseAssociate.equals(ldapAssociate)) {
                                log.info("Associate '{}' has changes in LDAP, updating in database");
                                // update associate in database
                                return this.associateRepository.update(ldapAssociate);
                            }

                            // associate existed in the database and matches data currently in LDAP
                            return databaseAssociate;
                        } else {
                            log.info("Adding associate '{}' to the database in department '{}'", ldapAssociate.getDepartment().getName());
                            return this.associateRepository.create(ldapAssociate);
                        }
                    });
        }
    }*/
}
