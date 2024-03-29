package com.rams.backend.controllers;

import com.rams.backend.entities.Ben;
import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.services.BenService;
import com.rams.backend.services.ChuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ApiController {

    @Autowired
    private BenService benService;
    @Autowired
    private ChuyenXeService chuyenXeService;

}
