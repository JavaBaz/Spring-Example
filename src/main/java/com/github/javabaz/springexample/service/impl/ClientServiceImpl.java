package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.repository.ClientRepository;
import com.github.javabaz.springexample.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long, ClientRepository> implements ClientService {

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }
}