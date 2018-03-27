package com.skumar.iqs.domain.service;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.repository.interfaces.AssociateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Security service that handles operations such as returning the currently logged in
 * Associate.
 *
 * @author vfc90315
 * @since 7/14/2017
 */
@Service
@CacheConfig(cacheNames = {"security"})
public class SecurityService {
    private AssociateRepository associateRepository;

    @Autowired
    public SecurityService(AssociateRepository associateRepository) {
        this.associateRepository = associateRepository;
    }

    @Cacheable(value = "currentAssociate")
    public Associate currentAssociate() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();

            if (authentication != null) {
                Object principal = authentication.getPrincipal();
                String associateNumber;

                if (principal instanceof UserDetails) {
                    associateNumber = ((UserDetails) principal).getUsername();
                } else {
                    associateNumber = principal.toString();
                }

                return this.associateRepository.findByAssociateNumber(associateNumber);
            }
        }

        return null;
    }
}
