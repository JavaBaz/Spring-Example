package com.github.javabaz.springexample.repository;

import com.github.javabaz.springexample.entity.offer.ExpertOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpertOfferRepository extends JpaRepository<ExpertOffer,Long> {
}
