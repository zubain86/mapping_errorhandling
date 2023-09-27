package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BillEntity {
    @Id
    @GeneratedValue
   private Long bill_id;
   private String name;
   private String email;
//    @OneToMany(targetEntity = DeviceEntity.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "bill_fk", referencedColumnName = "bill_id")
//   private List<DeviceEntity> devices;


    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    List<DeviceEntity> devices = new ArrayList<>();

    @OneToOne(targetEntity = UserAddressEntity.class,cascade = CascadeType.ALL)

    private UserAddressEntity address;
}
