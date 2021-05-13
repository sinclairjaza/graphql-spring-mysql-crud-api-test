package com.dilecompany.test.graphql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author SINCLAIR_JAZA
 * @Date 13/05/2021 - 07:47
 * @Project GraphQL Test
 */
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    private Category category;
}