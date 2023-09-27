package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAddressEntity {
    @Id
    @GeneratedValue
   private Long user_id;

   private String area;

   private String city;

   private String state;

   private String country;


}
