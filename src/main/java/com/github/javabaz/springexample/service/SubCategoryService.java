package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.exception.SubCategoryNotFoundException;

public interface SubCategoryService {

    SubCategory findByName(String name) throws SubCategoryNotFoundException;
}
