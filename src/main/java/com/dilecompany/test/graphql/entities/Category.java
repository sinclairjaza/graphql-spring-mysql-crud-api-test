package com.dilecompany.test.graphql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author SINCLAIR_JAZA
 * @Date 13/05/2021 - 07:45
 * @Project GraphQL Test
 */
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}