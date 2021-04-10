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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ghe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<VeXe> veXes = new HashSet<VeXe>();

    public Ghe() {
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public Ghe(String maGhe, LoaiGhe loaiGhe, TrangThaiGhe trangThaiGhe) {
        this.maGhe = maGhe;
        this.loaiGhe = loaiGhe;
        this.trangThaiGhe = trangThaiGhe;
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

}
