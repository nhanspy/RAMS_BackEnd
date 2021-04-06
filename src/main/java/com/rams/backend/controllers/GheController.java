package com.rams.backend.controllers;


import com.rams.backend.entities.Ben;
import com.rams.backend.entities.Ghe;
import com.rams.backend.services.BenService;
import com.rams.backend.services.GheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class GheController {
    @Autowired
    GheService gheService;

    @GetMapping("/ghe")
    public List<Ghe> tatCaGhe(){
        return gheService.getAll();
    }

    @GetMapping("/ghe/{id}")
    public Ghe layGheTheoId(@PathVariable(name = "id") String id){
        return gheService.get(id);
    }

    @PostMapping("/ghe")
    public void luuGhe(@RequestBody Ghe ghe){
        System.out.println(ghe.toString());
        gheService.save(ghe);
    }

    @DeleteMapping("/ghe/{id}")
    public void xoaGheTheoId(@PathVariable(name = "id")String id){
        gheService.delete(id);
    }

}
