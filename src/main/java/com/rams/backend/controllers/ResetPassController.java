package com.rams.backend.controllers;


import com.rams.backend.payload.request.MailRequest;
import com.rams.backend.payload.request.ResetPassRequest;
import com.rams.backend.payload.request.VerifyRequest;
import com.rams.backend.payload.response.MessageResponse;
import com.rams.backend.services.ResetPassService;
import com.sun.xml.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResetPassController {

    @Autowired
    ResetPassService resetPassService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/verify")
    public ResponseEntity<?> VerifyEmail(@RequestBody VerifyRequest code)
    {
        Boolean isVerified = resetPassService.findUserByVerificationCode(code.getCode());
        if (isVerified)
        {
            return ResponseEntity.ok(new MessageResponse("activated"));
        }else {
            return ResponseEntity.ok(new MessageResponse("error"));

        }
    }

    @PostMapping("/reset-password")

    public ResponseEntity<?> reset(@RequestBody MailRequest mailRequest) throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException {

        if (resetPassService.existsByEmail(mailRequest.getEmail()) != null) {
            resetPassService.addVerificationCode(mailRequest.getEmail());
            return ResponseEntity.ok(new MessageResponse("Sent email "));
        }
        System.out.println("Can not find email");
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không đúng"));
    }

    @PostMapping("/verify-password")
    public ResponseEntity<?> VerifyPassword(@RequestBody VerifyRequest code) {
        Boolean isVerified = resetPassService.findUserByVerificationCodeToResetPassword(code.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("accepted"));

        }
        else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }
    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        resetPassService.saveNewPassword(passwordEncoder.encode(resetPassRequest.getPassword()), resetPassRequest.getCode());
        return ResponseEntity.ok(new MessageResponse("success"));
    }


}
