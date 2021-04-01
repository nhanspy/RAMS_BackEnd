package com.rams.backend.services;

import com.rams.backend.entities.ChuyenXe;
import com.rams.backend.entities.Ghe;
import com.rams.backend.repositories.ChuyenXeRepository;
import com.rams.backend.repositories.GheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GheService {
    @Autowired
    GheRepository repository;

    public void save(Ghe ghe) {
        repository.save(ghe);
    }

    public Ghe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Ghe> getAll() {
        return repository.findAll();
    }
}
