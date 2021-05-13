package com.dilecompany.test.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.dilecompany.test.graphql.entities.Category;
import com.dilecompany.test.graphql.entities.Product;
import com.dilecompany.test.graphql.repositories.CategoryRepository;
import com.dilecompany.test.graphql.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author SINCLAIR_JAZA
 * @Date 13/05/2021 - 08:24
 * @Project GraphQL Test
 */
public class MutationResolver implements GraphQLMutationResolver {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MutationResolver (ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(String name){
        Category category = new Category();
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public Product addProduct(String name, String code, Double price, Long category_id) {

        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.saveAndFlush(product);
    }

    public Category updateCategory(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public Product updateProduct(Long id, String name, String code, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCode(code);
        product.setPrice(price);

        return productRepository.saveAndFlush(product);
    }

    public Boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    public Boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}