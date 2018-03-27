package com.skumar.iqs.controller.api;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.service.AssociateService;
import com.skumar.iqs.domain.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST API Controller for the Security entity.
 *
 * @author vfc91343
 * @since 3/22/2018
 */

@RestController
public class SecurityController {
    private SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @RequestMapping(value = "/api/security/principal", method = RequestMethod.GET)
    public Associate principal() {
        return this.securityService.currentAssociate();
    }
}