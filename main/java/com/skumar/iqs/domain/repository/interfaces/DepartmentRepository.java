package com.skumar.iqs.domain.repository.interfaces;

import com.skumar.iqs.domain.model.Department;

/**
 * Generic interface that extends the BaseRepository with
 * additional methods for the Department entity.
 *
 * @author vfc90315
 * @see Department
 * @see BaseRepository
 * @since 7/15/2017
 */
public interface DepartmentRepository extends BaseRepository<Department> {
    Iterable<Department> search(String term);
    Department findByName(String name);
}