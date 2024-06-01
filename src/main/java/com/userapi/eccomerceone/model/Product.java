package com.userapi.eccomerceone.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor // for case of parameter constructor
@NoArgsConstructor // for case of default or no argument constructor
@Entity
public class Product extends BaseModel {
  //product design
  private String title;
  private String description;
  private double price;
  private String imageUrl;
  @ManyToOne(cascade = CascadeType.PERSIST)
//  @ManyToOne
  private Category category;
}
