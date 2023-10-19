package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.exception.SubCategoryNotFoundException;
import com.github.javabaz.springexample.repository.SubCategoryRepository;
import com.github.javabaz.springexample.service.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;


    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }


    @Override
    public SubCategory findByName(String name) throws SubCategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findByName(name);
        if (subCategory == null){
            throw new SubCategoryNotFoundException("Category not found with name: " + name);
        }
        return subCategory;
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory saveOrUpdate(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

}
