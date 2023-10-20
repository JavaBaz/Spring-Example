package com.github.javabaz.springexample.service.impl;

import com.github.javabaz.springexample.base.service.impl.BaseServiceImpl;
import com.github.javabaz.springexample.entity.nameless.credit.Wallet;
import com.github.javabaz.springexample.repository.WalletRepository;
import com.github.javabaz.springexample.service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepository> implements WalletService {

    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }
}
