package com.rams.backend.controllers;

import com.rams.backend.entities.Ben;
import com.rams.backend.services.BenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BenController {
    @Autowired
    BenService benService;

    @GetMapping("/ben")
    public List<Ben> tatCaBen(){
        return benService.getAll();
    }

    @GetMapping("/ben/{id}")
    public Ben layBenTheoId(@PathVariable(name = "id") String id){
        return benService.get(id);
    }

    @PostMapping("/ben")
    public void luuBen(@RequestBody Ben ben){
//        System.out.println(ben.toString());
        benService.save(ben);
    }

    @GetMapping("/bentheotinh/{id}")
    public List<Ben> tatCaBenVoiMaTinh(@PathVariable(name = "id")String id){
        return benService.getAllByTinhThanh(id);
    }
    
    @DeleteMapping("/ben/{id}")
    public void xoaBenTheoId(@PathVariable(name = "id")String id){
        benService.delete(id);
    }

}
