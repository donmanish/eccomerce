package com.userapi.eccomerceone.repositories;

import com.userapi.eccomerceone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    //insert into product value ();
    Product findByTitle(String title);
    //select * from product Where title = {};
}
