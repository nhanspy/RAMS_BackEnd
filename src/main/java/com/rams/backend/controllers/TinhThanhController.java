package com.rams.backend.controllers;


import com.rams.backend.entities.TinhThanh;
import com.rams.backend.services.TinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TinhThanhController {
    @Autowired
    TinhThanhService service;

    @GetMapping("/tinhthanh")
    public List<TinhThanh> tatCaTinhThanh(){
        return service.getAll();
    }

    @GetMapping("/tinhthanh/{id}")
    public TinhThanh layTinhThanhTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/tinhthanh")
    public void luuLoaiTinhThanh(@RequestBody TinhThanh TinhThanh){
//        System.out.println(TinhThanh.toString());
        service.save(TinhThanh);
    }

    @DeleteMapping("/tinhthanh/{id}")
    public void xoaTinhThanhTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
