package com.github.javabaz.springexample.entity.nameless;

import com.github.javabaz.springexample.entity.withname.user.Client;
import com.github.javabaz.springexample.entity.withname.user.Expert;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_rating")
    private Date dateOfRating;

}
