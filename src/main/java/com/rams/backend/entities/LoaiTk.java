package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "loai_tk")
public class LoaiTk {
    @Id
    @Column(name = "ma_loai")
    private String maLoai;
    private String tenLoai;

    public LoaiTk() {
    }

    public LoaiTk(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loaiTk")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TaiKhoan> taiKhoans = new HashSet<>();

    @Override
    public String toString() {
        return "LoaiTk{" +
                "maLoai='" + maLoai + '\'' +
                ", tenLoai='" + tenLoai + '\'' +
//                ", taiKhoans=" + taiKhoans +
                '}';
    }
}
