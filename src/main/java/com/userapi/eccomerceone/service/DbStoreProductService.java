package com.userapi.eccomerceone.service;

import com.userapi.eccomerceone.model.Category;
import com.userapi.eccomerceone.model.Product;

import java.util.List;

public class DbStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long ProductId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long ProductId, Product updateDetails) {
        return null;
    }

    @Override
    public Product deleteProduct(Long ProductId) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return List.of();
    }

    @Override
    public Category getCategoryByTitle(String title) {
        return null;
    }
}
