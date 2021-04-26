package com.rams.backend.dto;

import java.util.Date;

public class VeXeDto {
    private Date thoiGian;
    private Long userNguoiDung;
    private Long userNhaXe;
    private String chuyenXe;
    private float giaTien;
    private boolean isThanhToan;
    private String ghe[];

    public VeXeDto(Date thoiGian, Long userNguoiDung, Long userNhaXe, String chuyenXe, float giaTien, boolean isThanhToan, String[] ghe) {
        this.thoiGian = thoiGian;
        this.userNguoiDung = userNguoiDung;
        this.userNhaXe = userNhaXe;
        this.chuyenXe = chuyenXe;
        this.giaTien = giaTien;
        this.isThanhToan = isThanhToan;
        this.ghe = ghe;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Long getUserNguoiDung() {
        return userNguoiDung;
    }

    public void setUserNguoiDung(Long userNguoiDung) {
        this.userNguoiDung = userNguoiDung;
    }

    public Long getUserNhaXe() {
        return userNhaXe;
    }

    public void setUserNhaXe(Long userNhaXe) {
        this.userNhaXe = userNhaXe;
    }

    public String getChuyenXe() {
        return chuyenXe;
    }

    public void setChuyenXe(String chuyenXe) {
        this.chuyenXe = chuyenXe;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public boolean isThanhToan() {
        return isThanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        isThanhToan = thanhToan;
    }

    public String[] getGhe() {
        return ghe;
    }

    public void setGhe(String[] ghe) {
        this.ghe = ghe;
    }
}
