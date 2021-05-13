package com.dilecompany.test.graphql.repositories;

import com.dilecompany.test.graphql.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SINCLAIR_JAZA
 * @Date 13/05/2021 - 07:53
 * @Project GraphQL Test
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
