package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class VeXe {
    @Id
    private String maVe;
    private String maTaiKhoanNhaXe;
    @Temporal(TemporalType.DATE)
    private Date thoiGian;
    private String maNguoiDung;
    private float giaTien;
    private String maGhe;

    public VeXe() {
    }

    public VeXe(String maVe, String maTaiKhoanNhaXe, Date thoiGian, String maNguoiDung, float giaTien, String maGhe) {
        this.maVe = maVe;
        this.maTaiKhoanNhaXe = maTaiKhoanNhaXe;
        this.thoiGian = thoiGian;
        this.maNguoiDung = maNguoiDung;
        this.giaTien = giaTien;
        this.maGhe = maGhe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaTaiKhoanNhaXe() {
        return maTaiKhoanNhaXe;
    }

    public void setMaTaiKhoanNhaXe(String maTaiKhoanNhaXe) {
        this.maTaiKhoanNhaXe = maTaiKhoanNhaXe;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }
}
