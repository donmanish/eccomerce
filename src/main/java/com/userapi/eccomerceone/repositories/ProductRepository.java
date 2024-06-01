package com.userapi.eccomerceone.repositories;

import com.userapi.eccomerceone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product); // for create
    //insert into product value ();
    Product findByTitle(String title);
    //select * from product Where title = {};
    Product findByDescription(String description);
}
