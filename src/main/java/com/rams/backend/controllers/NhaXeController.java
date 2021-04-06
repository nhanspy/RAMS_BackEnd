package com.rams.backend.controllers;


import com.rams.backend.entities.NhaXe;
import com.rams.backend.services.NhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class NhaXeController {
    @Autowired
    NhaXeService service;

    @GetMapping("/nhaxe")
    public List<NhaXe> tatCaNhaXe(){
        return service.getAll();
    }

    @GetMapping("/nhaxe/{id}")
    public NhaXe layNhaXeTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/nhaxe")
    public void luuLoaiNhaXe(@RequestBody NhaXe nhaXe){
        System.out.println(nhaXe.toString());
        service.save(nhaXe);
    }

    @DeleteMapping("/nhaxe/{id}")
    public void xoaNhaXeTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
