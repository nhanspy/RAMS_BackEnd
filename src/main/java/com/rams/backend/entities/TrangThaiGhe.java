package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TrangThaiGhe {
    @Id
    private String maTrangThai;
    private String tenTrangThai;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trangThaiGhe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ghe> ghes = new HashSet<Ghe>();

    public TrangThaiGhe() {
    }

    public Set<Ghe> getGhes() {
        return ghes;
    }

    public void setGhes(Set<Ghe> ghes) {
        this.ghes = ghes;
    }

    public TrangThaiGhe(String maTrangThai, String tenTrangThai, Set<Ghe> ghes) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
        this.ghes = ghes;
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