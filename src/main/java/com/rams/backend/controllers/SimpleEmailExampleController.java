package com.rams.backend.controllers;

import com.rams.backend.configs.MyConstants;
import com.rams.backend.helpers.ZXingHelper;
import com.rams.backend.payload.request.TicketMailRequest;
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
import javax.validation.Valid;
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

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendFromAngular(@Valid @RequestBody TicketMailRequest ticket) throws MessagingException, IOException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("successful ticket booking !!");
//        byte[] bytes = ZXingHelper.getQRCodeImage(ticket.getMaVe(), 300, 300);
//        String path2 = "data\\qrcode.png";
//        FileUtils.writeByteArrayToFile(new File(path2), bytes);
//
//        FileSystemResource file1 = new FileSystemResource(new File(path2));
//
//        helper.addAttachment("QRCode.png", file1);

        String htmlMsg = "<div class=\\\"m_-4448581987708125052content\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\\\">\\n\" +\n" +
                "                \"    <font color=\\\"#888888\\\"> </font>\\n\" +\n" +
                "                \"    <table\\n\" +\n" +
                "                \"        width=\\\"100%\\\"\\n\" +\n" +
                "                \"        cellpadding=\\\"0\\\"\\n\" +\n" +
                "                \"        cellspacing=\\\"0\\\"\\n\" +\n" +
                "                \"        style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; background-color: #fff; margin: 0; border: 1px solid #e9e9e9;\\\"\\n\" +\n" +
                "                \"        bgcolor=\\\"#fff\\\"\\n\" +\n" +
                "                \"    >\\n\" +\n" +
                "                \"        <tbody>\\n\" +\n" +
                "                \"            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                <td\\n\" +\n" +
                "                \"                    class=\\\"m_-4448581987708125052content-wrap\\\"\\n\" +\n" +
                "                \"                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: center; margin: 0; padding: 20px;\\\"\\n\" +\n" +
                "                \"                    align=\\\"center\\\"\\n\" +\n" +
                "                \"                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                >\\n\" +\n" +
                "                \"                    <font color=\\\"#888888\\\"> </font>\\n\" +\n" +
                "                \"                    <table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                    <h2\\n\" +\n" +
                "                \"                                        style=\\\"\\n\" +\n" +
                "                \"                                            font-family: 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif;\\n\" +\n" +
                "                \"                                            box-sizing: border-box;\\n\" +\n" +
                "                \"                                            font-size: 14px;\\n\" +\n" +
                "                \"                                            color: #000;\\n\" +\n" +
                "                \"                                            line-height: 1.2em;\\n\" +\n" +
                "                \"                                            font-weight: 400;\\n\" +\n" +
                "                \"                                            text-align: center;\\n\" +\n" +
                "                \"                                            margin: 40px 0 0;\\n\" +\n" +
                "                \"                                        \\\"\\n\" +\n" +
                "                \"                                        align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    >\\n\" +\n" +
                "                \"                                        You have successfully purchased your ticket at <span class=\\\"il\\\">Rams</span>.com!\\n\" +\n" +
                "                \"                                    </h2>\\n\" +\n" +
                "                \"                                    <h1\\n\" +\n" +
                "                \"                                        style=\\\"\\n\" +\n" +
                "                \"                                            font-family: 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif;\\n\" +\n" +
                "                \"                                            box-sizing: border-box;\\n\" +\n" +
                "                \"                                            font-size: 32px;\\n\" +\n" +
                "                \"                                            color: #000;\\n\" +\n" +
                "                \"                                            line-height: 1.2em;\\n\" +\n" +
                "                \"                                            font-weight: 500;\\n\" +\n" +
                "                \"                                            text-align: center;\\n\" +\n" +
                "                \"                                            margin: 40px 0 0;\\n\" +\n" +
                "                \"                                        \\\"\\n\" +\n" +
                "                \"                                        align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    >\\n\" +\n" +
                "                \"                                        RAMS\\n\" +\n" +
                "                \"                                    </h1>\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\" align=\\\"center\\\">\\n\" +\n" +
                "                \"                                    <img\\n\" +\n" +
                "                \"                                        src=\\\"https://ci4.googleusercontent.com/proxy/NQwRSZBhS_GJDAPhkLiU1rXV6uec7DxPmxSVN66eyZaVQGUjiMBas5ZONjPEQFaskrMtq5GHHgIxcbtrUG7--ItHaLtBeiE68gEKuzAwu2rTGnheTgodGVj4nJ0Uf2g3kyKhD5GLJ-6y-DXlpTG9R9Rc4dZBRS1YCvA_Jp4itPM1D0UmeNXvM6aTNDdhuTGrLyaTPHaKjaViin8OiUVGpPgziK0RvYssARc=s0-d-e1-ft#https://barcode.tec-it.com/barcode.ashx?data=127542644&amp;code+=Code128&amp;multiplebarcodes=true&amp;translate-esc=true&amp;unit=Fit&amp;dpi=96&amp;imagetype=Png&amp;rotation=0\\\"\\n\" +\n" +
                "                \"                                        class=\\\"CToWUd\\\"\\n\" +\n" +
                "                \"                                    />\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td\\n\" +\n" +
                "                \"                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: center; margin: 0; padding: 0 0 20px;\\\"\\n\" +\n" +
                "                \"                                    align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                >\\n\" +\n" +
                "                \"                                    <table class=\\\"m_-4448581987708125052invoice\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; text-align: left; width: 80%; margin: 30px auto;\\\">\\n\" +\n" +
                "                \"                                        <tbody>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    \"+ ticket.getTen() +\"<br style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\" />\\n\" +\n" +
                "                \"                                                    <a href=\\\"mailto:\"+ticket.getMail()+\"\\\" target=\\\"_blank\\\">\"+ticket.getMail()+\"</a>\\n\" +\n" +
                "                \"                                                    <br style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\" />\\n\" +\n" +
                "                \"                                                    \"+ ticket.getSoDienThoai() +\"\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td\\n\" +\n" +
                "                \"                                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0; padding: 5px 0; text-align: center; font-weight: bold;\\\"\\n\" +\n" +
                "                \"                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                >\\n\" +\n" +
                "                \"                                                    Ticket infomation\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    <table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                        <tbody>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Ticket code \\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getMaVe()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Seat\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getGhe()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Date\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getThoiGian().toString()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                        </tbody>\\n\" +\n" +
                "                \"                                                    </table>\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td\\n\" +\n" +
                "                \"                                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0; padding: 5px 0; text-align: center; font-weight: bold;\\\"\\n\" +\n" +
                "                \"                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                >\\n\" +\n" +
                "                \"                                                    Payment infomation\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    <table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                        <tbody>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    3x Standard\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    135,000 đ\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    width=\\\"80%\\\"\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #333;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        border-bottom-color: #333;\\n\" +\n" +
                "                \"                                                                        border-bottom-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-bottom-style: solid;\\n\" +\n" +
                "                \"                                                                        font-weight: 700;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Sum\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #333;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        border-bottom-color: #333;\\n\" +\n" +
                "                \"                                                                        border-bottom-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-bottom-style: solid;\\n\" +\n" +
                "                \"                                                                        font-weight: 700;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getTongTien()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                        </tbody>\\n\" +\n" +
                "                \"                                                    </table>\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                        </tbody>\\n\" +\n" +
                "                \"                                    </table>\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                    </table>\\n\" +\n" +
                "                \"                </td>\\n\" +\n" +
                "                \"            </tr>\\n\" +\n" +
                "                \"        </tbody>\\n\" +\n" +
                "                \"    </table>\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"</div>\\n";

        helper.setText(htmlMsg, true);

        String path2 = "data\\qrcode.png";

        byte[] bytes = ZXingHelper.getQRCodeImage(ticket.getMaVe(), 300, 300);
        FileUtils.writeByteArrayToFile(new File(path2), bytes);

        FileSystemResource file1 = new FileSystemResource(new File(path2));

        helper.addAttachment("QRCode.png", file1);

        emailSender.send(message);
    }

    @ResponseBody
    @RequestMapping("/send/{qrcode}/{mail_send}")
    public void sendFromJava(@PathVariable("qrcode") String qrcode, @PathVariable("mail_send") String mail_send) throws MessagingException, IOException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(mail_send);
        helper.setSubject("Rams gui ban Ve Xe");
        String htmlMsg = "<div class=\\\"m_-4448581987708125052content\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; max-width: 600px; display: block; margin: 0 auto; padding: 20px;\\\">\\n\" +\n" +
                "                \"    <font color=\\\"#888888\\\"> </font>\\n\" +\n" +
                "                \"    <table\\n\" +\n" +
                "                \"        width=\\\"100%\\\"\\n\" +\n" +
                "                \"        cellpadding=\\\"0\\\"\\n\" +\n" +
                "                \"        cellspacing=\\\"0\\\"\\n\" +\n" +
                "                \"        style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; border-radius: 3px; background-color: #fff; margin: 0; border: 1px solid #e9e9e9;\\\"\\n\" +\n" +
                "                \"        bgcolor=\\\"#fff\\\"\\n\" +\n" +
                "                \"    >\\n\" +\n" +
                "                \"        <tbody>\\n\" +\n" +
                "                \"            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                <td\\n\" +\n" +
                "                \"                    class=\\\"m_-4448581987708125052content-wrap\\\"\\n\" +\n" +
                "                \"                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: center; margin: 0; padding: 20px;\\\"\\n\" +\n" +
                "                \"                    align=\\\"center\\\"\\n\" +\n" +
                "                \"                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                >\\n\" +\n" +
                "                \"                    <font color=\\\"#888888\\\"> </font>\\n\" +\n" +
                "                \"                    <table width=\\\"100%\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                        <tbody>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 0 0 20px;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                    <h2\\n\" +\n" +
                "                \"                                        style=\\\"\\n\" +\n" +
                "                \"                                            font-family: 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif;\\n\" +\n" +
                "                \"                                            box-sizing: border-box;\\n\" +\n" +
                "                \"                                            font-size: 14px;\\n\" +\n" +
                "                \"                                            color: #000;\\n\" +\n" +
                "                \"                                            line-height: 1.2em;\\n\" +\n" +
                "                \"                                            font-weight: 400;\\n\" +\n" +
                "                \"                                            text-align: center;\\n\" +\n" +
                "                \"                                            margin: 40px 0 0;\\n\" +\n" +
                "                \"                                        \\\"\\n\" +\n" +
                "                \"                                        align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    >\\n\" +\n" +
                "                \"                                        You have successfully purchased your ticket at <span class=\\\"il\\\">Rams</span>.com!\\n\" +\n" +
                "                \"                                    </h2>\\n\" +\n" +
                "                \"                                    <h1\\n\" +\n" +
                "                \"                                        style=\\\"\\n\" +\n" +
                "                \"                                            font-family: 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif;\\n\" +\n" +
                "                \"                                            box-sizing: border-box;\\n\" +\n" +
                "                \"                                            font-size: 32px;\\n\" +\n" +
                "                \"                                            color: #000;\\n\" +\n" +
                "                \"                                            line-height: 1.2em;\\n\" +\n" +
                "                \"                                            font-weight: 500;\\n\" +\n" +
                "                \"                                            text-align: center;\\n\" +\n" +
                "                \"                                            margin: 40px 0 0;\\n\" +\n" +
                "                \"                                        \\\"\\n\" +\n" +
                "                \"                                        align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    >\\n\" +\n" +
                "                \"                                        RAMS\\n\" +\n" +
                "                \"                                    </h1>\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\" align=\\\"center\\\">\\n\" +\n" +
                "                \"                                    <img\\n\" +\n" +
                "                \"                                        src=\\\"https://ci4.googleusercontent.com/proxy/NQwRSZBhS_GJDAPhkLiU1rXV6uec7DxPmxSVN66eyZaVQGUjiMBas5ZONjPEQFaskrMtq5GHHgIxcbtrUG7--ItHaLtBeiE68gEKuzAwu2rTGnheTgodGVj4nJ0Uf2g3kyKhD5GLJ-6y-DXlpTG9R9Rc4dZBRS1YCvA_Jp4itPM1D0UmeNXvM6aTNDdhuTGrLyaTPHaKjaViin8OiUVGpPgziK0RvYssARc=s0-d-e1-ft#https://barcode.tec-it.com/barcode.ashx?data=127542644&amp;code+=Code128&amp;multiplebarcodes=true&amp;translate-esc=true&amp;unit=Fit&amp;dpi=96&amp;imagetype=Png&amp;rotation=0\\\"\\n\" +\n" +
                "                \"                                        class=\\\"CToWUd\\\"\\n\" +\n" +
                "                \"                                    />\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                <td\\n\" +\n" +
                "                \"                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: center; margin: 0; padding: 0 0 20px;\\\"\\n\" +\n" +
                "                \"                                    align=\\\"center\\\"\\n\" +\n" +
                "                \"                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                >\\n\" +\n" +
                "                \"                                    <table class=\\\"m_-4448581987708125052invoice\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; text-align: left; width: 80%; margin: 30px auto;\\\">\\n\" +\n" +
                "                \"                                        <tbody>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    \"+ ticket.getTen() +\"<br style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\" />\\n\" +\n" +
                "                \"                                                    <a href=\\\"mailto:\"+ticket.getMail()+\"\\\" target=\\\"_blank\\\">\"+ticket.getMail()+\"</a>\\n\" +\n" +
                "                \"                                                    <br style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\" />\\n\" +\n" +
                "                \"                                                    \"+ ticket.getSoDienThoai() +\"\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td\\n\" +\n" +
                "                \"                                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0; padding: 5px 0; text-align: center; font-weight: bold;\\\"\\n\" +\n" +
                "                \"                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                >\\n\" +\n" +
                "                \"                                                    Ticket infomation\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    <table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                        <tbody>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Ticket code \\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getMaVe()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Seat\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getGhe()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Date\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getThoiGian().toString()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                        </tbody>\\n\" +\n" +
                "                \"                                                    </table>\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td\\n\" +\n" +
                "                \"                                                    style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0; padding: 5px 0; text-align: center; font-weight: bold;\\\"\\n\" +\n" +
                "                \"                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                >\\n\" +\n" +
                "                \"                                                    Payment infomation\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                <td style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; margin: 0; padding: 5px 0;\\\" valign=\\\"top\\\">\\n\" +\n" +
                "                \"                                                    <table cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; width: 100%; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                        <tbody>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    3x Standard\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 1px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #eee;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    135,000 đ\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                            <tr style=\\\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\\\">\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    width=\\\"80%\\\"\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #333;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        border-bottom-color: #333;\\n\" +\n" +
                "                \"                                                                        border-bottom-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-bottom-style: solid;\\n\" +\n" +
                "                \"                                                                        font-weight: 700;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    Sum\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                                <td\\n\" +\n" +
                "                \"                                                                    style=\\\"\\n\" +\n" +
                "                \"                                                                        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\\n\" +\n" +
                "                \"                                                                        box-sizing: border-box;\\n\" +\n" +
                "                \"                                                                        font-size: 14px;\\n\" +\n" +
                "                \"                                                                        vertical-align: top;\\n\" +\n" +
                "                \"                                                                        text-align: right;\\n\" +\n" +
                "                \"                                                                        border-top-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-top-color: #333;\\n\" +\n" +
                "                \"                                                                        border-top-style: solid;\\n\" +\n" +
                "                \"                                                                        border-bottom-color: #333;\\n\" +\n" +
                "                \"                                                                        border-bottom-width: 2px;\\n\" +\n" +
                "                \"                                                                        border-bottom-style: solid;\\n\" +\n" +
                "                \"                                                                        font-weight: 700;\\n\" +\n" +
                "                \"                                                                        margin: 0;\\n\" +\n" +
                "                \"                                                                        padding: 5px 0;\\n\" +\n" +
                "                \"                                                                    \\\"\\n\" +\n" +
                "                \"                                                                    align=\\\"right\\\"\\n\" +\n" +
                "                \"                                                                    valign=\\\"top\\\"\\n\" +\n" +
                "                \"                                                                >\\n\" +\n" +
                "                \"                                                                    \"+ticket.getTongTien()+\"\\n\" +\n" +
                "                \"                                                                </td>\\n\" +\n" +
                "                \"                                                            </tr>\\n\" +\n" +
                "                \"                                                        </tbody>\\n\" +\n" +
                "                \"                                                    </table>\\n\" +\n" +
                "                \"                                                </td>\\n\" +\n" +
                "                \"                                            </tr>\\n\" +\n" +
                "                \"                                        </tbody>\\n\" +\n" +
                "                \"                                    </table>\\n\" +\n" +
                "                \"                                </td>\\n\" +\n" +
                "                \"                            </tr>\\n\" +\n" +
                "                \"                        </tbody>\\n\" +\n" +
                "                \"                    </table>\\n\" +\n" +
                "                \"                </td>\\n\" +\n" +
                "                \"            </tr>\\n\" +\n" +
                "                \"        </tbody>\\n\" +\n" +
                "                \"    </table>\\n\" +\n" +
                "                \"    \\n\" +\n" +
                "                \"</div>\\n";

        helper.setText(htmlMsg, true);

        String path2 = "data\\qrcode.png";

        byte[] bytes = ZXingHelper.getQRCodeImage(qrcode, 300, 300);
        FileUtils.writeByteArrayToFile(new File(path2), bytes);

        FileSystemResource file1 = new FileSystemResource(new File(path2));

        helper.addAttachment("QRCode.png", file1);

        emailSender.send(message);
//        return "redirect:http://localhost:4200/xuatve";
    }

    @ResponseBody
    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo("nhan0095@gmail.com");

        helper.setSubject("Test send HTML email");


        this.emailSender.send(message);

        return "Email Sent!";
    }

    @GetMapping("/mail")
    public String sendMail(Model model){
        return "sendmail";
    }

}