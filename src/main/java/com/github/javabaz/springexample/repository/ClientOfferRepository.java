package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.base.repository.BaseRepository;
import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;

import java.util.Collection;
import java.util.List;

public interface ClientOfferRepository extends BaseRepository<ClientOffer, Long> {

    List<ClientOffer> findBySubCategoryInAndOfferStatusIn(Collection<SubCategory> subCategories, Collection<OfferStatus> offerStatuses);
}
