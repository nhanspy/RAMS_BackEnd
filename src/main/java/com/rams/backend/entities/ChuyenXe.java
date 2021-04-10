package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChuyenXe {
    @Id
    private String maChuyen;
    @Temporal(TemporalType.DATE)
    private java.util.Date thoiGian;

    @ManyToOne
    @JoinColumn(name="ben_di")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ben benDi;

    @ManyToOne
    @JoinColumn(name="ben_den")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Ben benDen;

    @ManyToOne
    @JoinColumn(name="ma_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Xe xe;

    public ChuyenXe() {
    }

    public ChuyenXe(String maChuyen, Date thoiGian, Ben benDi, Ben benDen, Xe xe) {
        this.maChuyen = maChuyen;
        this.thoiGian = thoiGian;
        this.benDi = benDi;
        this.benDen = benDen;
        this.xe = xe;
    }

    @Override
    public String toString() {
        return "ChuyenXe{" +
                "maChuyen='" + maChuyen + '\'' +
                ", thoiGian=" + thoiGian +
                ", benDi=" + benDi +
                ", benDen=" + benDen +
                ", xe=" + xe +
                '}';
    }

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
