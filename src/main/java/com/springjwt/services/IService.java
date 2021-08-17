package com.springjwt.services;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    T findById(long id);

    T save(T item);

    void update(T item);

    void delete(long id);
}
