package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.offer.ClientOffer;
import com.github.javabaz.springexample.entity.offer.ExpertOffer;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.exception.ClientOfferNotAvailableException;
import com.github.javabaz.springexample.exception.OfferDateException;
import com.github.javabaz.springexample.exception.OfferPriceException;
import com.github.javabaz.springexample.repository.ExpertOfferRepository;
import com.github.javabaz.springexample.service.ClientOfferService;
import com.github.javabaz.springexample.service.ExpertOfferService;
import com.github.javabaz.springexample.service.ExpertService;
import com.github.javabaz.springexample.util.Validator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpertOfferServiceImpl extends BaseServiceImpl<ExpertOffer, Long, ExpertOfferRepository> implements ExpertOfferService {

    ExpertService expertService;
    ClientOfferService clientOfferService;

    public ExpertOfferServiceImpl(ExpertOfferRepository repository, ExpertService expertService, ClientOfferService clientOfferService) {
        super(repository);
        this.expertService = expertService;
        this.clientOfferService = clientOfferService;
    }

    @Override
    @Transactional
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

        ExpertOffer savedExpertOffer = repository.save(expertOffer);

        if (clientOffer.getOfferStatus() == OfferStatus.WAITING_TO_EXPERT_OFFER) {
            clientOffer.setOfferStatus(OfferStatus.WAITING_TO_CHOOSE_AN_EXPERT);
            clientOfferService.saveOrUpdate(clientOffer);
        }
        return savedExpertOffer;
    }
    }
