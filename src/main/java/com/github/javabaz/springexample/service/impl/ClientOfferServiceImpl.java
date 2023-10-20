package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.Rating;
import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.exception.InvalidRateException;
import com.github.javabaz.springexample.repository.ClientOfferRepository;
import com.github.javabaz.springexample.service.ClientOfferService;
import com.github.javabaz.springexample.service.ExpertService;
import com.github.javabaz.springexample.service.RatingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ClientOfferServiceImpl extends BaseServiceImpl<ClientOffer, Long, ClientOfferRepository> implements ClientOfferService {

    private RatingService ratingService;
    private ExpertService expertService;

    public ClientOfferServiceImpl(ClientOfferRepository repository, RatingService ratingService, ExpertService expertService) {
        super(repository);
        this.ratingService = ratingService;
        this.expertService = expertService;
    }

    @Override
    public List<ClientOffer> findBySubCategoryInAndOfferStatusIn(Collection<SubCategory> subCategories, Collection<OfferStatus> offerStatuses) {
        return repository.findBySubCategoryInAndOfferStatusIn(subCategories,offerStatuses);
    }

    @Override
    public List<ClientOffer> findAllClientOffersByClient(Client client) {
        return repository.findAllByClient(client);
    }

    @Override
    @Transactional
    public ClientOffer rateExpert(ClientOffer clientOffer, int rating, String description) {

        Expert expert = clientOffer.getChosenExpertToDoJob();
        if (expert == null) {
            throw new InvalidRateException("This offer has no chosen expert");
        }

        if (rating < 1 || rating > 5) {
            throw new InvalidRateException("Rate must be between 1 to 5");
        }

        Rating ratingEntity = new Rating();
        ratingEntity.setClient(clientOffer.getClient());
        ratingEntity.setExpert(expert);
        ratingEntity.setRating(rating);
        ratingEntity.setDescription(description);
        ratingEntity.setDateOfRating(new Date());

        ratingService.saveOrUpdate(ratingEntity);

        expertService.updateExpertAverageRating(expert);

        return repository.save(clientOffer);
    }


}