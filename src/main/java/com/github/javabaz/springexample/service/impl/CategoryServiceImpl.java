package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.Category;
import com.github.javabaz.springexample.repository.CategoryRepository;
import com.github.javabaz.springexample.service.CategoryService;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category,Long,CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }


}

