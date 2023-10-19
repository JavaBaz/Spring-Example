package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
