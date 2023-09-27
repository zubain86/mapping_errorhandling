package com.example.demo.validator;

import com.example.demo.service.DeviceValidationService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class DeviceValidation implements DeviceValidationService {
    @Override
    public void deviceValidation(List<String> devices) {
        for (String device: devices) {
            if(device.equals("Magenta"))
                log.warn("This colour is not used for the model");
            else
                log.info("Valid device");
        }
    }
}
