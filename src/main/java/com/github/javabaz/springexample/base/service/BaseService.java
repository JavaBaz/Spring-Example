package com.github.javabaz.springexample.base.service;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface BaseService<T, ID> {
    T findByName(String name) throws EntityNotFoundException;
    List<T> findAll();
    T saveOrUpdate(T entity);
    void delete(String name) throws EntityNotFoundException;
}