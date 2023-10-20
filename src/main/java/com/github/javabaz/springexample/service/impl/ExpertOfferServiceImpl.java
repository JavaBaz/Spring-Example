package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.offer.ExpertOffer;
import com.github.javabaz.springexample.repository.ExpertOfferRepository;
import com.github.javabaz.springexample.service.ExpertOfferService;
import org.springframework.stereotype.Service;

@Service
public class ExpertOfferServiceImpl extends BaseServiceImpl<ExpertOffer, Long, ExpertOfferRepository> implements ExpertOfferService {

    public ExpertOfferServiceImpl(ExpertOfferRepository repository) {
        super(repository);
    }
}