package com.rams.backend.controllers;


import com.rams.backend.entities.Xe;
import com.rams.backend.services.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class XeController {
    @Autowired
    XeService service;

    @GetMapping("/xe")
    public List<Xe> tatCaXe(){
        return service.getAll();
    }

    @GetMapping("/xe/{id}")
    public Xe layXeTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/xe")
    public void luuLoaiXe(@RequestBody Xe Xe){
        System.out.println(Xe.toString());
        service.save(Xe);
    }

    @DeleteMapping("/xe/{id}")
    public void xoaXeTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
