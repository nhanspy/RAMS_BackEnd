package com.rams.backend.controllers;


import com.rams.backend.dto.VeXeDto;
import com.rams.backend.entities.VeXe;
import com.rams.backend.services.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class VeXeController {
    @Autowired
    VeXeService service;

    @GetMapping("/vexe")
    public List<VeXe> tatCaVeXe(){
        return service.getAll();
    }

    @GetMapping("/vexe/{id}")
    public VeXe layVeXeTheoId(@PathVariable(name = "id") String id){
        return service.get(id);
    }

    @PostMapping("/vexe")
    public List<String> luuLoaiVeXe(@RequestBody VeXeDto VeXe){
        return service.save(VeXe);
    }

    @PostMapping("/vexe/updateState")
    public String updateState(@RequestBody String[] maVe){
        return service.updateState(maVe);
    }

    @DeleteMapping("/vexe/{id}")
    public void xoaVeXeTheoId(@PathVariable(name = "id")String id){
        service.delete(id);
    }

}
