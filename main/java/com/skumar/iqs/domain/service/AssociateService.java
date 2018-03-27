package com.skumar.iqs.domain.service;

import com.skumar.iqs.domain.model.Associate;
import com.skumar.iqs.domain.model.Department;
import com.skumar.iqs.domain.repository.interfaces.AssociateRepository;
import com.skumar.iqs.domain.repository.interfaces.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class description goes here...
 *
 * @author Devin Spivey
 * @since 7/6/2017
 */
@Service
public class AssociateService implements BaseService<Associate> {
    private AssociateRepository associateRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public AssociateService(AssociateRepository associateRepository, DepartmentRepository departmentRepository) {
        this.associateRepository = associateRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public int count() {
        return this.associateRepository.count();
    }

    @Override
    public Associate create(Associate associate) {
        return this.associateRepository.create(associate);
    }

    @Override
    public Associate update(Associate associate) {
        return this.associateRepository.update(associate);
    }

    @Override
    public int delete(Associate associate) {
        return this.associateRepository.delete(associate.getAssociateId());
    }

    @Override
    public int delete(int id) {
        return this.associateRepository.delete(id);
    }

    @Override
    public int deleteAll() {
        return this.associateRepository.deleteAll();
    }

    @Override
    public Associate findOne(int id) {
        return findOne(id, false);
    }

    @Override
    public Associate findOne(int id, boolean populateReferences) {
        Associate associate = this.associateRepository.findOne(id);
        if(populateReferences) populateDepartment(associate);

        return associate;
    }

    @Override
    public Iterable<Associate> findAll() {
        return findAll(false);
    }

    @Override
    public Iterable<Associate> findAll(boolean populateReferences) {
        Iterable<Associate> associates = this.associateRepository.findAll();
        if(populateReferences) populateDepartments(associates);

        return associates;
    }

    public Iterable<Associate> findByDepartmentId(int departmentId){
        return findByDepartmentId(departmentId, false);
    }

    public Iterable<Associate> findByDepartmentId(int departmentId, boolean populateReferences){
        Iterable<Associate> associates = this.associateRepository.findByDepartmentId(departmentId);
        if(populateReferences) populateDepartments(associates);

        return associates;
    }

    public Iterable<Associate> search(String name){
        return this.associateRepository.search(name);
    }

    public Iterable<Associate> search(String name, boolean populateReferences){
        Iterable<Associate> associates = this.associateRepository.search(name);
        if(populateReferences) populateDepartments(associates);

        return associates;
    }

    public Associate findByAssociateNumber(String associateNumber){
        return findByAssociateNumber(associateNumber, false);
    }

    public Associate findByAssociateNumber(String associateNumber, boolean populateReferences){
        Associate associate = this.associateRepository.findByAssociateNumber(associateNumber);
        if(populateReferences) populateDepartment(associate);

        return associate;
    }

    private Iterable<Associate> populateDepartments(Iterable<Associate> associates){
        for (Associate associate : associates){
            populateDepartment(associate);
        }

        return associates;
    }

    private Associate populateDepartment(Associate associate){
        if(associate != null){
            Department department = this.departmentRepository.findOne(associate.getDepartmentId());
            associate.setDepartment(department != null ? department : new Department());
        }

        return associate;
    }
}
