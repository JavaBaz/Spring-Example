package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.repository.ClientRepository;
import com.github.javabaz.springexample.service.ClientService;
import com.github.javabaz.springexample.util.Validator;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long, ClientRepository> implements ClientService {

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

    @Override
    public void updatePassword(Client client, String password) {
        if(!Validator.isPasswordStrong(password)){
            System.out.println("New Password is not strong!");
        }else {
            client.setPassword(password);
            repository.save(client);
        }
    }
    }
