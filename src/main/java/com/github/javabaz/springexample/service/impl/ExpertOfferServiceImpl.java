package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.offer.ExpertOffer;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.exception.ClientOfferNotAvailableException;
import com.github.javabaz.springexample.exception.OfferDateException;
import com.github.javabaz.springexample.exception.OfferPriceException;
import com.github.javabaz.springexample.repository.ExpertOfferRepository;
import com.github.javabaz.springexample.service.ExpertOfferService;
import com.github.javabaz.springexample.service.ExpertService;
import com.github.javabaz.springexample.util.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpertOfferServiceImpl extends BaseServiceImpl<ExpertOffer, Long, ExpertOfferRepository> implements ExpertOfferService {

    ExpertService expertService;

    public ExpertOfferServiceImpl(ExpertOfferRepository repository, ExpertService expertService) {
        super(repository);
        this.expertService = expertService;
    }

    @Override
    public ExpertOffer makeCounterOffer(Expert expert, ClientOffer clientOffer, int counterOfferAmount) throws OfferPriceException, OfferDateException {

        List<ClientOffer> availableOffers = expertService.findAvailableOffers(expert);


        if (!availableOffers.contains(clientOffer)) {
            throw new ClientOfferNotAvailableException("ClientOffer is not available for counter offer.");
        }


        ExpertOffer expertOffer = new ExpertOffer();
        expertOffer.setName(Validator.getSpacedStringInput());
        expertOffer.setClientOffer(clientOffer);
        expertOffer.setExpert(expert);
        expertOffer.setExpertOfferedDate(Validator.getLocalDateTimeInput());
        expertOffer.setDaysNeedToWork(Validator.getIntInput());
        expertOffer.setOfferedWage(counterOfferAmount);
        expertOffer.setExpertOfferDateSigned(LocalDateTime.now());

        if (counterOfferAmount < clientOffer.getSubCategory().getMinimumWage()) {
            throw new OfferPriceException("Counter offer amount is less than the minimum wage.");
        }

        if (expertOffer.getExpertOfferedDate().isBefore((LocalDateTime.now()))) {
            throw new OfferDateException("ExpertOfferedDate cannot be before the current date and time.");
        }


        return repository.save(expertOffer);
    }
    }
