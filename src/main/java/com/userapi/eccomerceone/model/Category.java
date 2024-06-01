package com.userapi.eccomerceone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor // for case of parameter constructor
@NoArgsConstructor // for case of default or no argument constructor
@Entity
public class Category extends BaseModel{
    private String title;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}
