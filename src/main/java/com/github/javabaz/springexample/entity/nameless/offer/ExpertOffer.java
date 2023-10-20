package com.github.javabaz.springexample.entity.nameless.offer;

import com.github.javabaz.springexample.entity.withname.user.Expert;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "expert_offer_table")
@Getter
@Setter
@ToString
public class ExpertOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private ClientOffer clientOffer;

    @ManyToOne
    private Expert expert;

    @Column(name = "expert_offered_date")
    private LocalDate expertOfferedDate;

    @Column(name = "days_need_to_work")
    private int daysNeedToWork;

    @Column(name = "offered_wage")
    private int offeredWage;

    @Column(name = "expert_offer_date_signed")
    @NotNull(message = "Expert offer date signed can not be null")
    private LocalDateTime ExpertOfferDateSigned;


}
