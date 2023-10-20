package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.nameless.credit.Rating;
import com.github.javabaz.springexample.repository.RatingRepository;
import com.github.javabaz.springexample.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl extends BaseServiceImpl<Rating, Long, RatingRepository> implements RatingService {

    public RatingServiceImpl(RatingRepository repository) {
        super(repository);
    }
}