package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.offer.ClientOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOfferRepository extends JpaRepository<ClientOffer,Long> {
}
