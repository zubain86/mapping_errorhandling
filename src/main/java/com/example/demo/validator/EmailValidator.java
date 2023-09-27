package com.example.demo.validator;

import com.example.demo.service.EmailValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class EmailValidator implements EmailValidationService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    @Override
    public void emailValidation(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if( matcher.matches())
            log.info("Email is valid");
        else
            log.warn("Email is invalid");

    }
}
