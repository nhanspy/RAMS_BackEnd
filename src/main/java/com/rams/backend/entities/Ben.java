package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ben {
    @Id
    private String maBen;
    private String tenBen;

    @ManyToOne
    @JoinColumn(name="ma_tinh")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TinhThanh tinhThanh;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "benDi")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ChuyenXe> chuyenXeBenDi = new HashSet<ChuyenXe>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "benDen")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ChuyenXe> chuyenXeBenDen = new HashSet<ChuyenXe>();

    public Ben() {
    }

    public Ben(String maBen, String tenBen, TinhThanh tinhThanh, Set<ChuyenXe> chuyenXeBenDi, Set<ChuyenXe> chuyenXeBenDen) {
        this.maBen = maBen;
        this.tenBen = tenBen;
        this.tinhThanh = tinhThanh;
        this.chuyenXeBenDi = chuyenXeBenDi;
        this.chuyenXeBenDen = chuyenXeBenDen;
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

    public TinhThanh getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(TinhThanh tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
//
//    public Set<ChuyenXe> getChuyenXeBenDi() {
//        return chuyenXeBenDi;
//    }
//
//    public void setChuyenXeBenDi(Set<ChuyenXe> chuyenXeBenDi) {
//        this.chuyenXeBenDi = chuyenXeBenDi;
//    }
//
//    public Set<ChuyenXe> getChuyenXeBenDen() {
//        return chuyenXeBenDen;
//    }
//
//    public void setChuyenXeBenDen(Set<ChuyenXe> chuyenXeBenDen) {
//        this.chuyenXeBenDen = chuyenXeBenDen;
//    }
}