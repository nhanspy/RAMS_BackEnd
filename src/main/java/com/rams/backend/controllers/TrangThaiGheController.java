package com.rams.backend.controllers;


import com.rams.backend.entities.TrangThaiGhe;
import com.rams.backend.services.TrangThaiGheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrangThaiGheController {
    @Autowired
    TrangThaiGheService service;

    @GetMapping("/trangthaighe")
    public List<TrangThaiGhe> tatCaTrangThaiGhe(){
        return service.getAll();
    }

    @GetMapping("/trangthaighe/{id}")
    public TrangThaiGhe layTrangThaiGheTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/trangthaighe")
    public void luuLoaiTrangThaiGhe(@RequestBody TrangThaiGhe TrangThaiGhe){
        System.out.println(TrangThaiGhe.toString());
        service.save(TrangThaiGhe);
    }

    @DeleteMapping("/trangthaighe/{id}")
    public void xoaTrangThaiGheTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
