package com.rams.backend.services;

import com.rams.backend.entities.LoaiTk;
import com.rams.backend.entities.NhaXe;
import com.rams.backend.repositories.LoaiTkRepository;
import com.rams.backend.repositories.NhaXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXeService {

    @Autowired
    NhaXeRepository repository;

    public void save(NhaXe nhaXe) {
        repository.save(nhaXe);
    }

    public NhaXe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<NhaXe> getAll() {
        return repository.findAll();
    }
}
