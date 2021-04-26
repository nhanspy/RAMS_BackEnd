package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ghe {
    @Id
    private String maGhe;

    @ManyToOne
    @JoinColumn(name="ma_loai_ghe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LoaiGhe loaiGhe;

    @ManyToOne
    @JoinColumn(name="ma_trang_thai")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TrangThaiGhe trangThaiGhe;

    @ManyToOne
    @JoinColumn(name="ma_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Xe xe;

    private int soGhe;
    private int tang;
    private int hang;
    private float gia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ghe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<VeXe> veXes = new HashSet<VeXe>();

    public Ghe() {
    }

    public String getXe() {
        return xe.getMaXe();
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public Ghe(String maGhe, LoaiGhe loaiGhe, TrangThaiGhe trangThaiGhe, int soGhe, int tang, float gia) {
        this.maGhe = maGhe;
        this.loaiGhe = loaiGhe;
        this.trangThaiGhe = trangThaiGhe;
        this.soGhe = soGhe;
        this.tang = tang;
        this.gia = gia;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public TrangThaiGhe getTrangThaiGhe() {
        return trangThaiGhe;
    }

    public void setTrangThaiGhe(TrangThaiGhe trangThaiGhe) {
        this.trangThaiGhe = trangThaiGhe;
    }

    public LoaiGhe getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LoaiGhe loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }
}