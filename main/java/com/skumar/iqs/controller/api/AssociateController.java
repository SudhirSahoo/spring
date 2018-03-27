package com.skumar.iqs.controller.api;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

/**
 * REST API Controller for the Associate entity.
 *
 * @author vfc91343 
 * @since 3/22/2018
 */

@RestController
public class AssociateController {
    private AssociateService associateService;

    @Autowired
    public AssociateController(AssociateService associateService) {
        this.associateService = associateService;
    }

    @RequestMapping(value = "/api/associate", method = RequestMethod.POST, consumes = "application/json")
    public Associate create(@RequestBody Associate associate) {
        return associateService.create(associate);
    }

    @RequestMapping(value = "/api/associate", method = RequestMethod.PUT, consumes = "application/json")
    public Associate update(@RequestBody Associate associate) {
        return associateService.update(associate);
    }

    @RequestMapping(value = "/api/associate/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public int delete(@PathVariable int id) {
        return associateService.delete(id);
    }

    @RequestMapping(value = "/api/associate/{id}", method = RequestMethod.GET)
    public Associate findOne(@PathVariable int id) {
        return associateService.findOne(id);
    }

    @RequestMapping(value = "/api/associate", method = RequestMethod.GET)
    public Iterable<Associate> findAll() {
        return associateService.findAll(true);
    }

    @RequestMapping(value = "/api/associate", params = "name", method = RequestMethod.GET)
    public Iterable<Associate> search(@RequestParam("name") String name) {
        return associateService.search(name, true);
    }
}