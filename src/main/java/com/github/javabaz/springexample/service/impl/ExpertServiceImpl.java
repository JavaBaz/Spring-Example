package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.ExpertStatus;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.repository.ExpertRepository;
import com.github.javabaz.springexample.service.ClientOfferService;
import com.github.javabaz.springexample.service.ExpertService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpertServiceImpl extends BaseServiceImpl<Expert, Long, ExpertRepository> implements ExpertService {

    ClientOfferService clientOfferService;


    public ExpertServiceImpl(ExpertRepository repository, ClientOfferService clientOfferService) {
        super(repository);
        this.clientOfferService = clientOfferService;
    }


    @Override
    public List<ClientOffer> findAvailableOffers(Expert expert) {
        Set<SubCategory> expertSubCategories = expert.getSubCategories();

        if (expertSubCategories.isEmpty() || expert.getExpertStatus() != ExpertStatus.APPROVED ) {
            return Collections.emptyList();
        }

        List<OfferStatus> allowedStatuses = Arrays.asList(OfferStatus.WAITING_TO_EXPERT_OFFER, OfferStatus.WAITING_TO_CHOOSE_AN_EXPERT);

        return clientOfferService.findBySubCategoryInAndOfferStatusIn(expertSubCategories, allowedStatuses);
    }
}