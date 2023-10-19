package com.github.javabaz.springexample.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_category_table")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "minimum_wage")
    private Integer minimumWage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
