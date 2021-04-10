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
    private String maTaiKhoanNhaXe;
    @Temporal(TemporalType.DATE)
    private Date thoiGian;

    @ManyToOne
    @JoinColumn(name="ma_nguoi_dung")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User userNguoiDung;

    @ManyToOne
    @JoinColumn(name="ma_nha_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User userNhaXe;

    private float giaTien;

    @ManyToOne
    @JoinColumn(name="ma_ghe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ghe ghe;


    public VeXe() {
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

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }
}