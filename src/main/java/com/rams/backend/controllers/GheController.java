package com.rams.backend.controllers;


import com.rams.backend.entities.Ghe;
import com.rams.backend.entities.Xe;
import com.rams.backend.payload.request.GheRequest;
import com.rams.backend.repositories.GheRepository;
import com.rams.backend.repositories.TrangThaiGheRepository;
import com.rams.backend.services.GheService;
import com.rams.backend.services.VeXeService;
import com.rams.backend.services.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class GheController {
    @Autowired
    GheService gheService;

    @Autowired
    XeService xeService;

    @Autowired
    VeXeService veXeService;

    @Autowired
    GheRepository gheRepository;
    @Autowired
    TrangThaiGheRepository trangThaiGheRepository;

    @GetMapping("/ghe")
    public List<Ghe> tatCaGhe(){
        return gheService.getAll();
    }

    @GetMapping("/ghe/{id}")
    public Ghe layGheTheoId(@PathVariable(name = "id") String id){
        return gheService.get(id);
    }

    @GetMapping("/ghe/xe/{maXe}")
    public List<Ghe> getByMaXe(@PathVariable(name = "maXe") String maXe){
        Xe xe = xeService.get(maXe);
        return gheService.getByXe(xe);
    }

    @PostMapping("/ghe")
    public void luuGhe(@RequestBody Ghe ghe){
        System.out.println(ghe.toString());
        gheService.save(ghe);
    }

    @PostMapping("/ghe/updateGhe")
    public String updateGhe(@RequestBody String[] strMaVes){
        List<String> strMaGhes = veXeService.getMaGheTheoVeXe(strMaVes);
        return gheService.updateGhe(strMaGhes);
//        return "sucsess";
    }

    @PostMapping("/ghe/updateTrangThaiGhe")
    public String updateTrangThaiGhe(@RequestBody GheRequest ghe){
        System.out.println(ghe.toString());
        return gheService.updateTrangThaiGhe(ghe);
    }

    @DeleteMapping("/ghe/{id}")
    public void xoaGheTheoId(@PathVariable(name = "id")String id){
        gheService.delete(id);
    }

}
