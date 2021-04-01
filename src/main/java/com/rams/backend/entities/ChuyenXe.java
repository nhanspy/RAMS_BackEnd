package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class ChuyenXe {
    @Id
    private String maChuyen;
    private String maXe;
    private String benDi;
    private String benDen;
    @Temporal(TemporalType.DATE)
    private java.util.Date thoiGian;

    public ChuyenXe() {
    }

    public ChuyenXe(String maChuyen, String maXe, String benDi, String benDen, Date thoiGian) {
        this.maChuyen = maChuyen;
        this.maXe = maXe;
        this.benDi = benDi;
        this.benDen = benDen;
        this.thoiGian = thoiGian;
    }

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getBenDi() {
        return benDi;
    }

    public void setBenDi(String benDi) {
        this.benDi = benDi;
    }

    public String getBenDen() {
        return benDen;
    }

    public void setBenDen(String benDen) {
        this.benDen = benDen;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
