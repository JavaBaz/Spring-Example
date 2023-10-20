package com.github.javabaz.springexample.repository;

import ch.qos.logback.classic.pattern.LineSeparatorConverter;
import com.github.javabaz.springexample.base.repository.BaseRepository;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Client;

import java.util.List;

public interface ClientRepository extends BaseRepository<Client, Long> {
    void updateByPassword(Client client,String password);

}
