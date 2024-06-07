package com.userapi.eccomerceone.repositories;

import com.userapi.eccomerceone.model.Product;
import com.userapi.eccomerceone.repositories.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product); // for create
    //insert into product value ();
    Product findByTitle(String title);
    //select * from product Where title = {};
    Product findByDescription(String description);

    //How to implement HQL
    @Query("select p from Product p  where p.category.id = :categoryId")
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

    //==> to connect with @query we need @Param (infuse)

    //How to implement native queries
    @Query(value = "select * from product p  where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductWithNativQueryByCategoryId(@Param("categoryId") Long categoryId);

    //HQl with Projection
    //Allows you to fetch certain specific coloums from the database
    @Query("select p.title as title, p.id as id from Product p  where p.category.id = :categoryId")
    List<ProductProjection> getProductByCategoryIdProjection(@Param("categoryId") Long categoryId);

}
