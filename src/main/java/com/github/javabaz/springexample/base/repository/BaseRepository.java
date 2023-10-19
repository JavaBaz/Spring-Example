package com.github.javabaz.springexample.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
    T findByName(String name);
}