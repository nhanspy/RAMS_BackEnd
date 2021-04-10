package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TrangThaiGhe {
    @Id
    private String maTrangThai;
    private String tenTrangThai;

    public TrangThaiGhe() {
    }

    public TrangThaiGhe(String maTrangThai, String tenTrangThai) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
