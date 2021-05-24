package com.rams.backend.services;


import com.rams.backend.entities.role_user.User;
import com.rams.backend.repositories.ResetPassRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class ResetPassServiceImp implements ResetPassService {


    @Autowired
    ResetPassRepository resetPassRepository;

@Autowired
    JavaMailSender javaMailSender;


    @Override
    public Boolean findUserByVerificationCode(String code) {
        User user = resetPassRepository.findUserByVerificationCode(code);
        if(user == null) {
            return false;
        }else {
            user.setVerificationCode(null);
            resetPassRepository.save(user);
            return true;
        }
    }

    @Override
    public Boolean findUserByVerificationCodeToResetPassword(String code) {
        User user = resetPassRepository.findUserByVerificationCode(code);
        return user !=null;
    }

    @Override
    public String existsByEmail(String email) {
        return resetPassRepository.existsByEmail(email);
    }

    @Override
    public void addVerificationCode(String email) throws MessagingException, UnsupportedEncodingException {

        String code = RandomString.make(64);
        resetPassRepository.addVerificationCode(code, email);
        User user = resetPassRepository.findUserByVerificationCode(code);
        this.sendVerificationEmailForResetPassWord(user.getUsername(), code, user.getEmail());
    }

    @Override
    public void saveNewPassword(String password, String code) {
        resetPassRepository.saveNewPassword(password,code);

    }
    public void sendVerificationEmailForResetPassWord(String userName, String randomCode, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Hãy xác thực email của bạn";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/doimatkhau?code=" + randomCode;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("lethithao2809@gmail.com");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p sytle='color:red;'>Xin chào " + userName + " ,<p>" + "<p> Nhấn vào link sau để xác thực email của bạn:</p>" +
                "<h3><a href='" + confirmUrl + "'>Nhấn vào đây để xác thực!</a></h3>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);
    }
}
