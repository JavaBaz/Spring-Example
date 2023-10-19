package com.github.javabaz.springexample.base.service.impl;

import com.github.javabaz.springexample.base.repository.BaseRepository;
import com.github.javabaz.springexample.base.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T, ID, R extends BaseRepository<T, ID>> implements BaseService<T, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T findByName(String name) throws EntityNotFoundException {
        T entity = repository.findByName(name);
        if (entity == null) {
            throw new EntityNotFoundException("Entity not found with name: " + name);
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T saveOrUpdate(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String name) throws EntityNotFoundException {
        T entity = findByName(name);
        repository.delete(entity);
    }
}