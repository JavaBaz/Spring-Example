package com.github.javabaz.springexample.entity.offer;


import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.enums.OfferStatus;
import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.entity.user.Expert;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_offer_table")
@Getter
@Setter
@ToString
public class ClientOffer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Client client;

    @ManyToOne
    private SubCategory subCategory;

    private int offeredWage;

    private String description;

    private String address;

    @Column(name = "client_offer_date")
    @NotNull(message = "Expert offer date can not be null")
    private LocalDateTime clientOfferDate;

    @Column(name = "client_offer_date_signed")
    @NotNull(message = "Expert offer date signed can not be null")
    private LocalDateTime clientOfferDateSigned;

    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    @ManyToOne
    private Expert chosenExpertToDoJob;
}
