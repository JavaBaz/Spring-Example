package com.github.javabaz.springexample.entity.user;

import com.github.javabaz.springexample.entity.credit.Wallet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_table")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "first_name")
    @NotNull(message = "First name can not be null")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name can not be null")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @NotNull(message = "Password can not be null")
    private String password;

    @Column(name = "sign_up_date")
    @NotNull(message = "sign up date can not be null")
    private LocalDateTime signUpDate;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
