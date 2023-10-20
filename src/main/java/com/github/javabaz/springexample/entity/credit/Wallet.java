package com.github.javabaz.springexample.entity.credit;

import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.entity.user.Expert;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "balance")
    private double balance;

    @OneToOne(mappedBy = "wallet")
    private Expert expert;

    @OneToOne(mappedBy = "wallet")
    private Client client;
}