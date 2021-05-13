package com.dilecompany.test.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dilecompany.test.graphql.entities.Category;
import com.dilecompany.test.graphql.entities.Product;
import com.dilecompany.test.graphql.repositories.CategoryRepository;
import com.dilecompany.test.graphql.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author SINCLAIR_JAZA
 * @Date 13/05/2021 - 07:56
 * @Project GraphQL Test
 */
public class QueryResolver implements GraphQLQueryResolver {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public QueryResolver(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Category category(Long id){
        return categoryRepository.findById(id).orElseGet(null);
    }

    public Product product(Long id){
        return productRepository.findById(id).orElseGet(null);
    }
}