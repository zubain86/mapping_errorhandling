package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BillEntity {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue
    private Long bill_id;

    private String name;
    private String email;
    @OneToMany(targetEntity = DeviceEntity.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_fk", referencedColumnName = "bill_id")
    private List<DeviceEntity> devices;


//    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
//    List<DeviceEntity> devices = new ArrayList<>();

    @OneToOne(targetEntity = UserAddressEntity.class, cascade = CascadeType.ALL)
    private UserAddressEntity address;

    public Long getBill_id() {
        return bill_id;
    }

    public void setBill_id(Long bill_id) {
        this.bill_id = bill_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceEntity> devices) {
        this.devices = devices;
    }

    public UserAddressEntity getAddress() {
        return address;
    }

    public void setAddress(UserAddressEntity address) {
        this.address = address;
    }


}
