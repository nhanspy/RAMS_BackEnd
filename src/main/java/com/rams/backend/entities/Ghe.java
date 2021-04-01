package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ghe {
    @Id
    private String maGhe;
    private String maLoaiGhe;
    private String maTrangThai;

    public Ghe(String maGhe, String maLoaiGhe, String maTrangThai) {
        this.maGhe = maGhe;
        this.maLoaiGhe = maLoaiGhe;
        this.maTrangThai = maTrangThai;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaLoaiGhe() {
        return maLoaiGhe;
    }

    public void setMaLoaiGhe(String maLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public Ghe() {
    }
}
