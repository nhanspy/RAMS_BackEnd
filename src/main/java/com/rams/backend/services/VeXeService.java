package com.rams.backend.services;

import com.rams.backend.dto.VeXeDto;
import com.rams.backend.entities.VeXe;
import com.rams.backend.entities.role_user.User;
import com.rams.backend.repositories.ChuyenXeRepository;
import com.rams.backend.repositories.GheRepository;
import com.rams.backend.repositories.UserRepository;
import com.rams.backend.repositories.VeXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<String> save(VeXeDto veXeDto) {
        Random rand = new Random();
        int upperbound = 10000;
        String maVeXe = "";
        List<String> strDanhSachVe = new ArrayList<String>();
        VeXe veXe;
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
            veXe.setMaVe(maVeXe);
            veXe.setThoiGian(veXeDto.getThoiGian());
            veXe.setUserNguoiDung(userRepository.getOne(veXeDto.getUserNguoiDung()));
            veXe.setUserNhaXe(userRepository.getOne(veXeDto.getUserNhaXe()));
            veXe.setChuyenXe(chuyenXeRepository.findById(veXeDto.getChuyenXe()).get());
            veXe.setGiaTien(veXe.getGiaTien());
            veXe.setGhe(gheRepository.getOne(ghe));
            veXeRepository.save(veXe);
            strDanhSachVe.add(maVeXe);
        }
        return strDanhSachVe;
    }

    public String updateState(String[] maVes){
        VeXe veXe;
        for (String maVe:
             maVes) {
            veXe = veXeRepository.getOne(maVe);
            veXe.setThanhToan(true);
            save(veXe);
        }
        return "{ \"data\" :  \"Success!!\"}";
    }

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
