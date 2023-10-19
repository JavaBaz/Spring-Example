package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.entity.Category;
import com.github.javabaz.springexample.exception.CategoryNotFoundException;

import java.util.List;


public interface CategoryService {

    Category findByName(String name) throws CategoryNotFoundException;

    List<Category> findAll();

    Category saveOrUpdate(Category category);

    void delete(String name) throws CategoryNotFoundException;

}
