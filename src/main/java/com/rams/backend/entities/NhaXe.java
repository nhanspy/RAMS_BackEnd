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
public class NhaXe {
    @Id
    private String maNhaXe;
    private String tenNhaXe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaXe")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Xe> xes = new HashSet<Xe>();

    public NhaXe() {
    }

    public NhaXe(String maNhaXe, String tenNhaXe) {
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
    }

    public String getMaNhaXe() {
        return maNhaXe;
    }

    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    @Override
    public String toString() {
        return "NhaXe{" +
                "maNhaXe='" + maNhaXe + '\'' +
                ", tenNhaXe='" + tenNhaXe + '\'' +
                ", xes=" + xes +
                '}';
    }
}
