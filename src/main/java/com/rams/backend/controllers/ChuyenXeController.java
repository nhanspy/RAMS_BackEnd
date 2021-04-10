package com.rams.backend.controllers;


import com.rams.backend.entities.Ben;
import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.services.BenService;
import com.rams.backend.services.ChuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ChuyenXeController {
    @Autowired
    ChuyenXeService chuyenXeService;

    @GetMapping("/chuyenxe")
    public List<ChuyenXe> tatCaChuyenXe(){
        return chuyenXeService.getAll();
    }

    @GetMapping("/chuyenxe/{id}")
    public ChuyenXe layChuyenXeTheoId(@PathVariable(name = "id") String id){
        return chuyenXeService.get(id);
    }

    @PostMapping("/chuyenxe")
    public void luuChuyenXe(@RequestBody ChuyenXe chuyenXe){
        System.out.println(chuyenXe.toString());
        chuyenXeService.save(chuyenXe);
    }

    @DeleteMapping("/chuyenxe/{id}")
    public void xoaChuyenXeTheoId(@PathVariable(name = "id")String id){
        chuyenXeService.delete(id);
    }

}