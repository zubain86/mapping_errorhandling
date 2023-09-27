package com.example.demo.service;

import com.example.demo.dto.BillDTO;
import com.sendgrid.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmailService {
    Response emailSendService(BillDTO billDTO, MultipartFile[] files) throws IOException;
}