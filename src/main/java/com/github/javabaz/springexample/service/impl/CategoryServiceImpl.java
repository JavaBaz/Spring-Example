package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.entity.Category;
import com.github.javabaz.springexample.exception.CategoryNotFoundException;
import com.github.javabaz.springexample.repository.CategoryRepository;
import com.github.javabaz.springexample.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}

