package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.user.Expert;
import com.github.javabaz.springexample.repository.ExpertRepository;
import com.github.javabaz.springexample.service.ExpertService;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceImpl extends BaseServiceImpl<Expert, Long, ExpertRepository> implements ExpertService {

    public ExpertServiceImpl(ExpertRepository repository) {
        super(repository);
    }
}