package com.rams.backend.controllers;


import com.rams.backend.entities.Ben;
import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.entities.TinhThanh;
import com.rams.backend.services.BenService;
import com.rams.backend.services.ChuyenXeService;
import com.rams.backend.services.TinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ChuyenXeController {
    @Autowired
    ChuyenXeService chuyenXeService;
    @Autowired
    TinhThanhService tinhThanhService;
    @Autowired
    BenService benService;


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

    @GetMapping("/chuyenxe/{maTinhDi}/{maTinhDen}")
    public ArrayList<ChuyenXe> tatCaChuyenXeTheoTinh(@PathVariable(name = "maTinhDi") String maTinhDi, @PathVariable(name = "maTinhDen") String maTinhDen){
        List<ChuyenXe> chuyenXes = chuyenXeService.getAll();

        List<Ben> benDis = benService.getAllByTinhThanh(maTinhDi);
        List<Ben> benDens = benService.getAllByTinhThanh(maTinhDen);
        ArrayList<ChuyenXe> chuyenXesResult = new ArrayList<ChuyenXe>();

        for (ChuyenXe chuyenXe:
             chuyenXes) {
            for (Ben benDi :
                    benDis) {
                for (Ben benDen:
                    benDens){
                    System.out.println("=====================================");
                    System.out.println(benDi.getMaBen() + " ---- " + benDen.getMaBen() + " ---- " + chuyenXe.getBenDen().getMaBen() + " ---- " + chuyenXe.getBenDen().getMaBen());
                    System.out.println("=====================================");
                    if (chuyenXe.getBenDi().getMaBen().equals(benDi.getMaBen()) && chuyenXe.getBenDen().getMaBen().equals(benDen.getMaBen())){
                        chuyenXesResult.add(chuyenXe);

                    }
                }
            }
        }
        return chuyenXesResult;
    }


    @DeleteMapping("/chuyenxe/{id}")
    public void xoaChuyenXeTheoId(@PathVariable(name = "id")String id){
        chuyenXeService.delete(id);
    }

}