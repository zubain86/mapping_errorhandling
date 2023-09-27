package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BillDTO {
   private Long bill_id;
   private String email;
   private String name;
   private List<DeviceDTO> devices;

   private UserAddressDTO address;

   private String emailResponse;


}
