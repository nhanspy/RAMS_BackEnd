package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chuyenXe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<VeXe> veXes = new HashSet<VeXe>();

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

    public Ben getBenDi() {
        return benDi;
    }

    public void setBenDi(Ben benDi) {
        this.benDi = benDi;
    }

    public Ben getBenDen() {
        return benDen;
    }

    public void setBenDen(Ben benDen) {
        this.benDen = benDen;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }
}