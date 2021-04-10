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
public class TinhThanh {
    @Id
    private String maTinh;
    private String tenTinh;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tinhThanh")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Ben> bens = new HashSet<Ben>();

    public TinhThanh() {
    }

    public TinhThanh(String maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }
}
