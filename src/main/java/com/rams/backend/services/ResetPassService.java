package com.rams.backend.services;



import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface ResetPassService {

    Boolean findUserByVerificationCode(String code);


    Boolean findUserByVerificationCodeToResetPassword(String code);


    String existsByEmail(String email);

    void addVerificationCode(String email) throws MessagingException, UnsupportedEncodingException, MessagingException, MessagingException;


    void saveNewPassword(String password, String code);
}
