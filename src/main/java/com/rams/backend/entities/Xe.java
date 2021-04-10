package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Xe {
    @Id
    private String maXe;
    private String bienSoXe;
    private String maLoaiXe;
    private String maNhaXe;

    public Xe() {
    }

    public Xe(String maXe, String bienSoXe, String maLoaiXe, String maNhaXe) {
        this.maXe = maXe;
        this.bienSoXe = bienSoXe;
        this.maLoaiXe = maLoaiXe;
        this.maNhaXe = maNhaXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getMaNhaXe() {
        return maNhaXe;
    }

    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }
}
