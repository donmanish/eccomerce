package com.userapi.eccomerceone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor // for case of parameter constructor
@NoArgsConstructor // for case of default or no argument constructor
public class Product {
  //product design
  private long id;
  private String title;
  private String description;
  private double price;
  private String imageUrl;
  private Category category;
}
