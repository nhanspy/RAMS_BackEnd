package com.rams.backend.services;

import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.entities.LoaiGhe;
import com.rams.backend.entities.LoaiTk;
import com.rams.backend.repositories.ChuyenXeRepository;
import com.rams.backend.repositories.LoaiTkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiTkService {
    @Autowired
    LoaiTkRepository repository;

    public void save(LoaiTk loaiTk) {
        repository.save(loaiTk);
    }

    public LoaiTk get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<LoaiTk> getAll() {
        return repository.findAll();
    }
}
