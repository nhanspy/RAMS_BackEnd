package com.rams.backend.services;

import com.rams.backend.entities.Ben;
import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.repositories.BenRepository;
import com.rams.backend.repositories.ChuyenXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenXeService {
    @Autowired
    ChuyenXeRepository repository;

    public void save(ChuyenXe chuyenXe) {
        repository.save(chuyenXe);
    }

    public ChuyenXe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<ChuyenXe> getAll() {
        return repository.findAll();
    }

}
