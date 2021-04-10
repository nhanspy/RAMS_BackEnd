package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Xe {
    @Id
    private String maXe;
    private String bienSoXe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ghe> ghes = new HashSet<Ghe>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ChuyenXe> chuyenXes = new HashSet<ChuyenXe>();

    @ManyToOne
    @JoinColumn(name="ma_nha_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private NhaXe nhaXe;

    @ManyToOne
    @JoinColumn(name="ma_loai_xe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LoaiXe loaiXe;

    public Xe() {
    }

    public Xe(String maXe, String bienSoXe, Set<Ghe> ghes, Set<ChuyenXe> chuyenXes, NhaXe nhaXe, LoaiXe loaiXe) {
        this.maXe = maXe;
        this.bienSoXe = bienSoXe;
        this.ghes = ghes;
        this.chuyenXes = chuyenXes;
        this.nhaXe = nhaXe;
        this.loaiXe = loaiXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public Set<Ghe> getGhes() {
        return ghes;
    }

    public void setGhes(Set<Ghe> ghes) {
        this.ghes = ghes;
    }

    public Set<ChuyenXe> getChuyenXes() {
        return chuyenXes;
    }

    public void setChuyenXes(Set<ChuyenXe> chuyenXes) {
        this.chuyenXes = chuyenXes;
    }

    public NhaXe getNhaXe() {
        return nhaXe;
    }

    public void setNhaXe(NhaXe nhaXe) {
        this.nhaXe = nhaXe;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "maXe='" + maXe + '\'' +
                ", bienSoXe='" + bienSoXe + '\'' +
                ", ghes=" + ghes +
                ", chuyenXes=" + chuyenXes +
                ", nhaXe=" + nhaXe +
                ", loaiXe=" + loaiXe +
                '}';
    }
}
