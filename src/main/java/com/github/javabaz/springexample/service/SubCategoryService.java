package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.exception.SubCategoryNotFoundException;

import java.util.List;

public interface SubCategoryService {

    SubCategory findByName(String name) throws SubCategoryNotFoundException;

    List<SubCategory> findAll();

    SubCategory saveOrUpdate(SubCategory subCategory);

    void delete(String name) throws SubCategoryNotFoundException;

}
