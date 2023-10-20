package com.github.javabaz.springexample.service;

import com.github.javabaz.springexample.base.service.BaseService;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Expert;

import java.util.List;

public interface ExpertService extends BaseService<Expert, Long> {
    List<ClientOffer> findAvailableOffers(Expert expert);
    void updateExpertAverageRating(Expert expert);
}
