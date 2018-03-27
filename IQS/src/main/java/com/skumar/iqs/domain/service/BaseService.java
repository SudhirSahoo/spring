package com.skumar.iqs.domain.service;

/**
 * Class description goes here...
 *
 * @author Devin Spivey
 * @since 7/6/2017
 */
public interface BaseService<T> {
    int count();

    T create(T item);

    //Iterable<T> create(Iterable<T> items);

    T update(T item);

    //Iterable<T> update(Iterable<T> items);

    int delete(T item);

    int delete(int id);

    int deleteAll();

    T findOne(int id);

    T findOne(int id, boolean populateReferences);

    Iterable<T> findAll();

    Iterable<T> findAll(boolean populateReferences);
}
