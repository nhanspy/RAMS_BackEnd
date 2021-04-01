package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ben {
    @Id
    private String maBen;
    private String tenBen;
    private String maTinh;

    public Ben() {
    }

    public Ben(String maBen, String tenBen, String maTinh) {
        this.maBen = maBen;
        this.tenBen = tenBen;
        this.maTinh = maTinh;
    }

    public String getMaBen() {
        return maBen;
    }

    public void setMaBen(String maBen) {
        this.maBen = maBen;
    }

    public String getTenBen() {
        return tenBen;
    }

    public void setTenBen(String tenBen) {
        this.tenBen = tenBen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }
}
