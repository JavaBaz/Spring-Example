package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.base.service.BaseService;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.offer.ExpertOffer;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.exception.OfferDateException;
import com.github.javabaz.springexample.exception.OfferPriceException;

public interface ExpertOfferService extends BaseService<ExpertOffer, Long> {

    ExpertOffer makeCounterOffer(Expert expert, ClientOffer clientOffer, int counterOfferAmount) throws OfferPriceException, OfferDateException;

}
