//package com.example.demo.service;
//
//import com.example.demo.dto.BillDTO;
//import com.sendgrid.Method;
//import com.sendgrid.Request;
//import com.sendgrid.Response;
//import com.sendgrid.SendGrid;
//import com.sendgrid.helpers.mail.Mail;
//import com.sendgrid.helpers.mail.objects.Attachments;
//import com.sendgrid.helpers.mail.objects.Content;
//import com.sendgrid.helpers.mail.objects.Email;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//@Service
//public class EmailServiceImpl implements EmailService{
//    SendGrid sendGrid;
//
//    public EmailServiceImpl(SendGrid sendGrid) {
//        this.sendGrid = sendGrid;
//    }
//
//    @Override
//    public Response emailSendService(BillDTO billDTO, MultipartFile[] files) throws IOException {
//        String body = "This is bill is created for " + billDTO.getName() + ". Thank you for shopping with us!";
//        Email to = new Email(billDTO.getEmail());
//        Mail mail = new Mail(new Email(), "Bill Created", to, new Content("text/plain", body));
//        for (MultipartFile file : files) {
//            try {
//                final InputStream inputStream = file.getInputStream();
//                final Attachments attachments = new Attachments
//                        .Builder(file.getOriginalFilename(), inputStream)
//                        .withType("application/pdf")
//                        .build();
//                mail.addAttachments(attachments);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }}
//        Request request = new Request();
//        Response response = null;
//        try {
//            request.setMethod(Method.POST);
//            request.setEndpoint("mail/send");
//            request.setBody(mail.build());
//            response = this.sendGrid.api(request);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return response;
//    }
//}
