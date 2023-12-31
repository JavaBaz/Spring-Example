package com.github.javabaz.springexample.entity.user;

import com.github.javabaz.springexample.entity.SubCategory;
import com.github.javabaz.springexample.entity.credit.Wallet;
import com.github.javabaz.springexample.entity.enums.ExpertStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expert_table")
public class Expert {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name",nullable = false)
    @NotNull(message = "Name can not be null")
    private String name;

    @Column(unique = true)
    private String email;

    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @NotNull(message = "Password can not be null")
    private String password;

    @Column(name = "sign_up_date")
    @NotNull(message = "sign up date can not be null")
    private LocalDateTime signUpDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Expert's status can not be null")
    private ExpertStatus expertStatus;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToMany
    @JoinTable(
            name = "expert_subcategory",
            joinColumns = @JoinColumn(name = "expert_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private Set<SubCategory> subCategories = new HashSet<>();

    @Min(0)
    @Max(5)
    private double averageRate;
}
