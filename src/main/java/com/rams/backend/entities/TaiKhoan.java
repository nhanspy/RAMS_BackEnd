package com.rams.backend.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @Column(name = "ma_tai_khoan")
    private String maTaiKhoan;
    private String ten;
    private String soDienThoai;
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    private String diaChi;
    private boolean gioiTinh;
    private String taiKhoan;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String maTaiKhoan, String ten, String soDienThoai, Date ngaySinh, String diaChi, boolean gioiTinh, String taiKhoan, String matKhau, LoaiTk loaiTk) {
        this.maTaiKhoan = maTaiKhoan;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTk = loaiTk;
    }

    public LoaiTk getLoaiTk() {
        return loaiTk;
    }

    public void setLoaiTk(LoaiTk loaiTk) {
        this.loaiTk = loaiTk;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @ManyToOne
    @JoinColumn(name="ma_loai")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LoaiTk loaiTk;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taiKhoanNguoiDung")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Set<VeXe> veXeNguoiDungs = new HashSet<VeXe>();
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taiKhoanNhaXe")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Set<VeXe> veXeNhaXes = new HashSet<VeXe>();

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "maTaiKhoan='" + maTaiKhoan + '\'' +
                ", ten='" + ten + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", loaiTk=" + loaiTk.getTenLoai() +
//                ", veXeNguoiDungs=" + veXeNguoiDungs +
//                ", veXeNhaXes=" + veXeNhaXes +
                '}';
    }
}