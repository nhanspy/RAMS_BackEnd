package com.rams.backend.controllers;

import com.rams.backend.entities.LoaiGhe;
import com.rams.backend.entities.LoaiXe;
import com.rams.backend.services.LoaiGheService;
import com.rams.backend.services.LoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class LoaiXeController {
    @Autowired
    LoaiXeService service;

    @GetMapping("/loaixe")
    public List<LoaiXe> tatCaLoaiXe(){
        return service.getAll();
    }

    @GetMapping("/loaixe/{id}")
    public LoaiXe layLoaiXeTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/loaixe")
    public void luuLoaiLoaiXe(@RequestBody LoaiXe loaiXe){
        System.out.println(loaiXe.toString());
        service.save(loaiXe);
    }

    @DeleteMapping("/loaixe/{id}")
    public void xoaLoaiXeTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
