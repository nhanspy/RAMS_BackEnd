package com.rams.backend.services;

import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.entities.Ghe;
import com.rams.backend.entities.Xe;
import com.rams.backend.repositories.ChuyenXeRepository;
import com.rams.backend.repositories.GheRepository;
import com.rams.backend.repositories.LoaiGheRepository;
import com.rams.backend.repositories.TrangThaiGheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GheService {
    @Autowired
    GheRepository gheRepository;
    @Autowired
    LoaiGheRepository loaiGheRepository;
    @Autowired
    TrangThaiGheRepository trangThaiGheRepository;

    public void save(Ghe ghe) {
        gheRepository.save(ghe);
    }

    public Ghe get(String id) {
        return gheRepository.findById(id).get();
    }

    public List<Ghe> getByXe(Xe xe) {
        return gheRepository.findAllByXe(xe);
    }

    public void delete(String id) {
        gheRepository.deleteById(id);
    }

    public List<Ghe> getAll() {
        return gheRepository.findAll();
    }

    public String updateGhe(String[] ghes) {
        Ghe ghe;
        for (String strGhe:
                ghes) {
            ghe = gheRepository.findById(strGhe).get();
            ghe.setTrangThaiGhe(trangThaiGheRepository.getOne("mttg03"));
            save(ghe);
        }
        return "{\"data\" : \"Success!!\"}";
    }
}
