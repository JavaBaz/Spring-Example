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


    @Override
    public Category findByName(String name) throws CategoryNotFoundException {
        Category category = categoryRepository.findByName(name);
        if (category == null) {
            throw new CategoryNotFoundException("Category not found with name: " + name);
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(String name) throws CategoryNotFoundException {
        Category category = findByName(name);
        categoryRepository.delete(category);
    }


}

