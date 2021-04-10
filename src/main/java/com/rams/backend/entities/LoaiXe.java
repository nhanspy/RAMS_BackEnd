package com.rams.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoaiXe {
    @Id
    private String maLoaiXe;
    private Integer soChoNgoi;

    public LoaiXe() {
    }

    public LoaiXe(String maLoaiXe, Integer soChoNgoi) {
        this.maLoaiXe = maLoaiXe;
        this.soChoNgoi = soChoNgoi;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public Integer getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(Integer soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }
}
