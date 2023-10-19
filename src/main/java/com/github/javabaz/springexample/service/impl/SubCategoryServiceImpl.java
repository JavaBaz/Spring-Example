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


}
