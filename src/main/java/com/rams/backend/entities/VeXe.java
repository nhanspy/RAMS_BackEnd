package com.rams.backend.entities;

import com.rams.backend.entities.role_user.User;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VeXe {
    @Id
    private String maVe;
//    private String maTaiKhoanNhaXe;
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGian;

    @ManyToOne
    @JoinColumn(name="ma_nguoi_dung")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User userNguoiDung;

    @ManyToOne
    @JoinColumn(name="ma_tai_khoan_nha_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User userNhaXe;

    @ManyToOne
    @JoinColumn(name="ma_chuyen_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ChuyenXe chuyenXe;

    private float giaTien;
    private boolean isThanhToan;

    @ManyToOne
    @JoinColumn(name="ma_ghe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ghe ghe;

    private String code;


    public VeXe() {
    }

    public VeXe(String maVe, Date thoiGian, User userNguoiDung, User userNhaXe, ChuyenXe chuyenXe, float giaTien, Ghe ghe, boolean isThanhToan) {
        this.maVe = maVe;
        this.thoiGian = thoiGian;
        this.userNguoiDung = userNguoiDung;
        this.userNhaXe = userNhaXe;
        this.chuyenXe = chuyenXe;
        this.giaTien = giaTien;
        this.ghe = ghe;
        this.isThanhToan = isThanhToan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isThanhToan() {
        return isThanhToan;
    }

    public void setThanhToan(boolean thanhToan) {
        isThanhToan = thanhToan;
    }

    public User getUserNguoiDung() {
        return userNguoiDung;
    }

    public void setUserNguoiDung(User userNguoiDung) {
        this.userNguoiDung = userNguoiDung;
    }

    public User getUserNhaXe() {
        return userNhaXe;
    }

    public void setUserNhaXe(User userNhaXe) {
        this.userNhaXe = userNhaXe;
    }

    public ChuyenXe getChuyenXe() {
        return chuyenXe;
    }

    public void setChuyenXe(ChuyenXe chuyenXe) {
        this.chuyenXe = chuyenXe;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
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

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }
}