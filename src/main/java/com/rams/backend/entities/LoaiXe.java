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
public class LoaiXe {
    @Id
    private String maLoaiXe;
    private Integer soChoNgoi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiXe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Xe> xes = new HashSet<Xe>();

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