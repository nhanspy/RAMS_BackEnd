package com.rams.backend.controllers;

import com.rams.backend.configs.MyConstants;
import com.rams.backend.helpers.ZXingHelper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;

@Controller
public class SimpleEmailExampleController {

    @Autowired
    public JavaMailSender emailSender;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }

    @ResponseBody
    @RequestMapping("/sendQrcode")
    public String sendAttachmentEmail(@RequestParam("qrcode") String qrcode) throws MessagingException, IOException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Rams test send mail!!");

        helper.setText("Hello, Im testing email with attachments qrcode!");

        String path2 = "data\\qrcode.png";

        byte[] bytes = ZXingHelper.getQRCodeImage(qrcode, 300, 300);
        FileUtils.writeByteArrayToFile(new File(path2), bytes);

        FileSystemResource file1 = new FileSystemResource(new File(path2));

        helper.addAttachment("QRCode.png", file1);

        emailSender.send(message);

        return "Email Sent!";
    }

    @ResponseBody
    @RequestMapping("/send")
    public String sendFromAngular( String qrcode) throws MessagingException, IOException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Rams test send mail!!");

        helper.setText("Hello, Im testing email with attachments qrcode!");

        String path2 = "data\\qrcode.png";

        byte[] bytes = ZXingHelper.getQRCodeImage(qrcode, 300, 300);
        FileUtils.writeByteArrayToFile(new File(path2), bytes);

        FileSystemResource file1 = new FileSystemResource(new File(path2));

        helper.addAttachment("QRCode.png", file1);

        emailSender.send(message);

        return "Email Sent!";
    }

    @ResponseBody
    @RequestMapping("/send/{qrcode}/{mail_send}")
    public void sendFromJava(@PathVariable("qrcode") String qrcode, @PathVariable("mail_send") String mail_send) throws MessagingException, IOException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(mail_send);
        helper.setSubject("Rams gui ban Ve Xe");

        helper.setText("Hello, Im sending email ticket with qrcode!");

        String path2 = "data\\qrcode.png";

        byte[] bytes = ZXingHelper.getQRCodeImage(qrcode, 300, 300);
        FileUtils.writeByteArrayToFile(new File(path2), bytes);

        FileSystemResource file1 = new FileSystemResource(new File(path2));

        helper.addAttachment("QRCode.png", file1);

        emailSender.send(message);
//        return "redirect:http://localhost:4200/xuatve";
    }

    @GetMapping("/mail")
    public String sendMail(Model model){
        return "sendmail";
    }

}