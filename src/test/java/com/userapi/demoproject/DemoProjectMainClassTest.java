package com.userapi.demoproject;

import com.userapi.eccomerceone.ProjectMainClass;
import com.userapi.eccomerceone.model.Product;
import com.userapi.eccomerceone.repositories.ProductRepository;

import com.userapi.eccomerceone.repositories.Projection.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ProjectMainClass.class)

public class DemoProjectMainClassTest {
   @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLads(){

    }
    @Test
    void testingHqlQuries(){
        List<Product> products = productRepository.getProductByCategoryId(1L);
        System.out.println(products.get(0));
    }
    @Test
    void testingNativeQuries(){
        List<Product> products = productRepository.getProductWithNativQueryByCategoryId(1L);
        System.out.println(products.get(0));
    }
    @Test
    void testingHqlProjection(){
        List<ProductProjection> projection = productRepository.getProductByCategoryIdProjection(1L);
        System.out.println(projection.get(0).getId());
    }
}
