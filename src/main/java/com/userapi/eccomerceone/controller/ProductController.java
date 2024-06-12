package com.userapi.eccomerceone.controller;

import com.userapi.eccomerceone.dto.ErrorDto;
import com.userapi.eccomerceone.exceptions.ProductNotFoundException;
import com.userapi.eccomerceone.model.Category;
import com.userapi.eccomerceone.model.Product;
import com.userapi.eccomerceone.service.FakeStoreProductService;
import com.userapi.eccomerceone.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    //POST(method) //Product(end point)
//    Request Body
//    {
//        "title": "test product",
//        "price": 13.8,
//        "description": "lorem ipsum set",
//        "image": "https: //i.pravatar.cc",
//        "category": "electronic"
//    }

    //  interact with service also known as Dependency injection
    //  ProductService productService = new FakeStoreProductService();
    //  spring to create depedency injection

//    @Autowired
   private  ProductService productService;

    //for for connection to database
    public ProductController(@Qualifier("dbStoreProductService") ProductService productService) {
        this.productService = productService;
    }

   //for fakeproduct seerce 3rd party integration
//    public ProductController(@Qualifier("fakeProductService") ProductService productService) {
//        this.productService = productService;
//    }


    //get all products----------------------------------------------
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //create a products
    @PostMapping("/products")
    public Product createProduct(@RequestBody  Product product ){
        //Whenever someone is doing a post request on /product
        //please execute this method
        Product postRequestResponse = productService.createProduct(product);
        return postRequestResponse;
    }

    //get single product with response Entity----------------------------------------
    //path parameters
    @GetMapping("/products/{id}")
    public ResponseEntity<Product>  getProduct(@PathVariable("id") Long  producdId) throws ProductNotFoundException {
        //Whenever someone is doing a get  request on /product
        //please execute this method

      Product currentProduct = productService.getSingleProduct(producdId);
      ResponseEntity<Product> res = new ResponseEntity<>(
              currentProduct, HttpStatus.OK
      );
      return res;
    }




    //update product--------------------------------------------
    @PutMapping("/products/{id}")
    public Product  updateProduct(@PathVariable("id") Long productId, @RequestBody Product updatedProductDetails){
        //Whenever someone is doing a get  request on /product
        //please execute this method

        Product updateProduct = productService.updateProduct(productId, updatedProductDetails);

        return updateProduct;
    }


    //delete product--------------------------------------------------
    @DeleteMapping("/products/{id}")
    public Product  deleteProduct(@PathVariable("id") Long  producdId){
        //Whenever someone is doing a get  request on /product
        //please execute this method

        Product deleteproduct = productService.deleteProduct(producdId);

        return deleteproduct;
    }

    //all category--------------------------------------------------
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return productService.getAllCategory();
    }

    //get specify category title--------------------------------------
    @GetMapping("/categories/{title}")
    public Category getCategory(@PathVariable("title") String title) {
        return productService.getCategoryByTitle(title);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e)
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    //backend aws connect work
    @GetMapping("/health")
    public ResponseEntity<String> checkHealthOfService()  {
        return new ResponseEntity<>("Backend service application work perfectly file", HttpStatus.OK);
    }

}
