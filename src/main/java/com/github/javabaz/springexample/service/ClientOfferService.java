package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.base.service.BaseService;
import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Client;

import java.util.Collection;
import java.util.List;

public interface ClientOfferService extends BaseService<ClientOffer, Long> {
    List<ClientOffer> findBySubCategoryInAndOfferStatusIn(Collection<SubCategory> subCategories, Collection<OfferStatus> offerStatuses) ;
    List<ClientOffer> findAllClientOffersByClient(Client client);
    ClientOffer rateExpert(ClientOffer clientOffer, int rating, String description);
    }
