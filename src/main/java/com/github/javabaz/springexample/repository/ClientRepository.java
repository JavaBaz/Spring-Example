package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}