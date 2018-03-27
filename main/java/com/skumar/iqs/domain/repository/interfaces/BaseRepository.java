package com.skumar.iqs.domain.repository.interfaces;

/**
 * Base repository interface for CRUD operations.
 *
 * @author Devin Spivey
 * @since 7/6/2017
 */
public interface BaseRepository<T> {
    int count();

    T create(T item);

    //Iterable<T> create(Iterable<T> items);

    T update(T item);

    //Iterable<T> update(Iterable<T> items);

    int delete(int id);

    int deleteAll();

    T findOne(int id);

    Iterable<T> findAll();
}
