package com.skumar.iqs.domain.repository.interfaces;

import com.skumar.iqs.domain.model.Associate;

/**
 * Generic interface that extends the BaseRepository with
 * additional methods for the Associate entity.
 *
 *
 * @author vfc90315
 * @see Associate
 * @see BaseRepository
 * @since 7/15/2017
 */
public interface AssociateRepository extends BaseRepository<Associate> {
    Iterable<Associate> search(String term);
    Iterable<Associate> findByDepartmentId(int departmentId);
    Associate findByAssociateNumber(String associateNumber);
}
