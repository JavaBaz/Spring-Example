package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
