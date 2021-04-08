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
public class LoaiGhe {
    @Id
    private String maLoaiGhe;
    private String tenLoaiGhe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiGhe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ghe> ghes = new HashSet<Ghe>();

    public LoaiGhe() {

    }

    public LoaiGhe(String maLoaiGhe, String tenLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
        this.tenLoaiGhe = tenLoaiGhe;
    }

    public String getMaLoaiGhe() {
        return maLoaiGhe;
    }

    public void setMaLoaiGhe(String maLoaiGhe) {
        this.maLoaiGhe = maLoaiGhe;
    }

    public String getTenLoaiGhe() {
        return tenLoaiGhe;
    }

    public void setTenLoaiGhe(String tenLoaiGhe) {
        this.tenLoaiGhe = tenLoaiGhe;
    }
}
