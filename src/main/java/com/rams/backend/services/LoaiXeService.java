package com.rams.backend.services;

import com.rams.backend.entities.LoaiXe;
import com.rams.backend.repositories.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService {

    @Autowired
    LoaiXeRepository repository;

    public void save(LoaiXe loaiXe) {
        repository.save(loaiXe);
    }

    public LoaiXe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<LoaiXe> getAll() {
        return repository.findAll();
    }
}
