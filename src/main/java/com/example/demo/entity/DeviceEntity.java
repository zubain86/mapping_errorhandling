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
public class DeviceEntity {
    @Id
    @GeneratedValue
   private Long device_id;

    private String deviceType;

   private String deviceColour;
//   @ManyToOne
//   @JoinColumn(name = "bill_id")
//   private BillEntity bill;


}
