package com.springjwt.dao;

import java.util.List;

public interface ICrud<T> {
    List<T> getAll();

    T findById(long id);

    T save(T item);

    T update(T item);

    void delete(long id);
}
