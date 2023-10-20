package com.github.javabaz.springexample.entity.nameless.credit;

import com.github.javabaz.springexample.entity.user.*;
import com.github.javabaz.springexample.entity.withname.user.Client;
import com.github.javabaz.springexample.entity.withname.user.Expert;
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

    @Column(name = "balance")
    private double balance;

    @OneToOne(mappedBy = "wallet")
    private Expert expert;

    @OneToOne(mappedBy = "wallet")
    private Client client;
}