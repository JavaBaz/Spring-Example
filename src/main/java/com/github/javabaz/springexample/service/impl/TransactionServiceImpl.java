package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.credit.Transaction;
import com.github.javabaz.springexample.repository.TransactionRepository;
import com.github.javabaz.springexample.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Long, TransactionRepository> implements TransactionService {

    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}