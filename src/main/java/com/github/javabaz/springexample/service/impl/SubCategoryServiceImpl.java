package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.withname.SubCategory;
import com.github.javabaz.springexample.repository.SubCategoryRepository;
import com.github.javabaz.springexample.service.SubCategoryService;
import org.springframework.stereotype.Service;


@Service
public class SubCategoryServiceImpl extends BaseServiceImpl<SubCategory,Long,SubCategoryRepository> implements SubCategoryService {


    public SubCategoryServiceImpl(SubCategoryRepository repository) {
        super(repository);
    }

}
