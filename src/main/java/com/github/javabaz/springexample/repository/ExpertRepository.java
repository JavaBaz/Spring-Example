package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.user.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertRepository extends JpaRepository<Expert,Long> {
}
