package com.rams.backend.services;

import com.rams.backend.entities.LoaiTk;
import com.rams.backend.entities.VeXe;
import com.rams.backend.repositories.LoaiTkRepository;
import com.rams.backend.repositories.VeXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeXeService {
    @Autowired
    VeXeRepository repository;

    public void save(VeXe veXe) {
        repository.save(veXe);
    }

    public VeXe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<VeXe> getAll() {
        return repository.findAll();
    }
}
