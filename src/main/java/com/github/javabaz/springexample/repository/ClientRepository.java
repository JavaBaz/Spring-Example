package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.base.repository.BaseRepository;
import com.github.javabaz.springexample.entity.user.Client;
import jakarta.validation.constraints.NotNull;


public interface ClientRepository extends BaseRepository<Client, Long> {
    @NotNull Client save(Client client);

}
