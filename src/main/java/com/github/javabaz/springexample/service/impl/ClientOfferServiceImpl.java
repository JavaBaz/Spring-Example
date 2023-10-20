package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.nameless.offer.ClientOffer;
import com.github.javabaz.springexample.repository.ClientOfferRepository;
import com.github.javabaz.springexample.service.ClientOfferService;
import org.springframework.stereotype.Service;

@Service
public class ClientOfferServiceImpl extends BaseServiceImpl<ClientOffer, Long, ClientOfferRepository> implements ClientOfferService {

    public ClientOfferServiceImpl(ClientOfferRepository repository) {
        super(repository);
    }
}