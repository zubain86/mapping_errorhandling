package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BillReq {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
   private List<DeviceReq> devices;
    @NotBlank
    private UserAddressReq address;

}
