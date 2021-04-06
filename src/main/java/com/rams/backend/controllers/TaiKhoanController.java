package com.rams.backend.controllers;


import com.rams.backend.entities.TaiKhoan;
import com.rams.backend.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService service;

    @GetMapping("/taikhoan")
    public List<TaiKhoan> tatCaTaiKhoan(){
        return service.getAll();
    }

    @GetMapping("/taikhoan/{id}")
    public TaiKhoan layTaiKhoanTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/taikhoan")
    public void luuLoaiTaiKhoan(@RequestBody TaiKhoan TaiKhoan){
        System.out.println(TaiKhoan.toString());
        service.save(TaiKhoan);
    }

    @DeleteMapping("/taikhoan/{id}")
    public void xoaTaiKhoanTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
