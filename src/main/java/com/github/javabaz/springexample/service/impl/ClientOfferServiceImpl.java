package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.repository.ClientOfferRepository;
import com.github.javabaz.springexample.service.ClientOfferService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClientOfferServiceImpl extends BaseServiceImpl<ClientOffer, Long, ClientOfferRepository> implements ClientOfferService {

    public ClientOfferServiceImpl(ClientOfferRepository repository) {
        super(repository);
    }


    @Override
    public List<ClientOffer> findBySubCategoryInAndOfferStatusIn(Collection<SubCategory> subCategories, Collection<OfferStatus> offerStatuses) {
        return repository.findBySubCategoryInAndOfferStatusIn(subCategories,offerStatuses);
    }

    @Override
    public List<ClientOffer> findAllClientOffersByClient(Client client) {
        return repository.findAllByClient(client);
    }


}