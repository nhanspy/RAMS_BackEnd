package com.rams.backend.services;

import com.rams.backend.dto.VeXeDto;
import com.rams.backend.entities.TrangThaiGhe;
import com.rams.backend.entities.VeXe;
import com.rams.backend.entities.role_user.User;
import com.rams.backend.repositories.*;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VeXeService {
    @Autowired
    VeXeRepository veXeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChuyenXeRepository chuyenXeRepository;
    @Autowired
    GheRepository gheRepository;
    @Autowired
    TrangThaiGheRepository trangThaiGheRepository;


    public List<String> save(VeXeDto veXeDto) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Random rand = new Random();
        int upperbound = 10000;
        String maVeXe = "";
        List<String> strDanhSachVe = new ArrayList<String>();
        VeXe veXe;
        int code = 0;
        for (String ghe :
                veXeDto.getGhe()) {
            veXe = new VeXe();
            Boolean bool;
            bool = true;
            VeXe veXeTmp = new VeXe();
            while (bool){
                maVeXe = "mv" + rand.nextInt(upperbound);
                bool = veXeRepository.existsById(maVeXe);
            }
            bool = true;
            while (bool) {
                code = rand.nextInt(99999999);
                code += 100000000;
                List<VeXe> veXes = veXeRepository.getAllByCode(code + "");
                bool = !veXes.isEmpty();
            }
            veXe.setMaVe(maVeXe);
            veXe.setThoiGian(veXeDto.getThoiGian());
            veXe.setUserNguoiDung(userRepository.getOne(veXeDto.getUserNguoiDung()));
            veXe.setUserNhaXe(userRepository.getOne(veXeDto.getUserNhaXe()));
            veXe.setChuyenXe(chuyenXeRepository.findById(veXeDto.getChuyenXe()).get());
            veXe.setGiaTien(veXe.getGiaTien());
            veXe.setGhe(gheRepository.getOne(ghe));
            veXe.setCode(code + "");

            veXeRepository.save(veXe);
            strDanhSachVe.add(maVeXe);
        }
        return strDanhSachVe;
    }

    public String soatVe(String code){
        VeXe veXe;
        veXe = veXeRepository.findByCode(code);
        TrangThaiGhe ttg = new TrangThaiGhe();
        ttg = trangThaiGheRepository.getOne("mttg04");//dang ngoi
        veXe.getGhe().setTrangThaiGhe(ttg);
        veXeRepository.save(veXe);
        return "{\"data\" : \"Chuyen trang thai dang ngoi thanh cong!\"}";
    }

    public List<String> updateState(String[] maVes){
        VeXe veXe;
        List<String> strCodes = new ArrayList<String>();
        for (String maVe:
             maVes) {
            veXe = veXeRepository.getOne(maVe);
            veXe.setThanhToan(true);
            strCodes.add(veXe.getCode());
            save(veXe);
        }
        return strCodes;
    }
    
    public List<String> getMaGheTheoVeXe(String[] maVes){
        VeXe veXe;
        List<String> strMaGhe = new ArrayList<>();
        for (String maVe:
                maVes) {
            veXe = veXeRepository.getOne(maVe);
            strMaGhe.add(veXe.getGhe().getMaGhe());
        }
        return strMaGhe;
    };

    public void save(VeXe veXe) {
        veXeRepository.save(veXe);
    }

    public VeXe get(String id) {
        return veXeRepository.findById(id).get();
    }

    public void delete(String id) {
        veXeRepository.deleteById(id);
    }

    public List<VeXe> getAll() {
        return veXeRepository.findAll();
    }
}
