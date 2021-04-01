package com.rams.backend.services;

import com.rams.backend.entities.LoaiGhe;
import com.rams.backend.repositories.LoaiGheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiGheService {
    @Autowired
    LoaiGheRepository repository;

    public void save(LoaiGhe loaiGhe) {
        repository.save(loaiGhe);
    }

    public LoaiGhe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<LoaiGhe> getAll() {
        return repository.findAll();
    }
}
