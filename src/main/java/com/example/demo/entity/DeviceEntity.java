package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class DeviceEntity {
    @Id
    @GeneratedValue
   private Long device_id;

    private String deviceType;

   private String deviceColour;
//   @ManyToOne
//   @JoinColumn(name = "bill_fk",referencedColumnName = "bill_id")
//   private BillEntity bill;

    public Long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceColour() {
        return deviceColour;
    }

    public void setDeviceColour(String deviceColour) {
        this.deviceColour = deviceColour;
    }

//    public BillEntity getBill() {
//        return bill;
//    }
//
//    public void setBill(BillEntity bill) {
//        this.bill = bill;
//
//    }
}
