package com.rams.backend.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketMailRequest {
    private String mail;
    private String ten;
    private String soDienThoai;
    private String ve;
    private String maVe;
    private Date thoiGian;
    private String link;
    private String ghe;
    private float tongTien;
    private int tongGhe;

    public int getTongGhe() {
        return tongGhe;
    }

    public void setTongGhe(int tongGhe) {
        this.tongGhe = tongGhe;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhe() {
        return ghe;
    }

    public void setGhe(String ghe) {
        this.ghe = ghe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getVe() {
        return ve;
    }

    public void setVe(String ve) {
        this.ve = ve;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
