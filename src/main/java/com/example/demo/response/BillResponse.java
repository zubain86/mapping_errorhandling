package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BillResponse {
    private String name;
    private List<DeviceResponse> devices;
    private String email;
    private String emailResponse;

}
