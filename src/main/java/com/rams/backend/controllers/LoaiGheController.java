package com.rams.backend.controllers;


import com.rams.backend.entities.Ben;
import com.rams.backend.entities.LoaiGhe;
import com.rams.backend.services.BenService;
import com.rams.backend.services.LoaiGheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class LoaiGheController {
    @Autowired
    LoaiGheService service;

    @GetMapping("/loaighe")
    public List<LoaiGhe> tatCaLoaiGhe(){
        return service.getAll();
    }

    @GetMapping("/loaighe/{id}")
    public LoaiGhe layLoaiGheTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/loaighe")
    public void luuLoaiGhe(@RequestBody LoaiGhe loaiGhe){
        System.out.println(loaiGhe.toString());
        service.save(loaiGhe);
    }

    @DeleteMapping("/loaighe/{id}")
    public void xoaLoaiGheTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}