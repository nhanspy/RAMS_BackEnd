package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NhaXe {
    @Id
    private String maNhaXe;
    private String tenNhaXe;

    public NhaXe() {
    }

    public NhaXe(String maNhaXe, String tenNhaXe) {
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
    }

    public String getMaNhaXe() {
        return maNhaXe;
    }

    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
}
