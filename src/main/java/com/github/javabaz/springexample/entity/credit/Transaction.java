package com.github.javabaz.springexample.entity.credit;

import com.github.javabaz.springexample.entity.user.Client;
import com.github.javabaz.springexample.entity.user.Expert;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction_table")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}