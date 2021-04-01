package com.rams.backend.services;

import com.rams.backend.entities.LoaiTk;
import com.rams.backend.entities.Xe;
import com.rams.backend.repositories.LoaiTkRepository;
import com.rams.backend.repositories.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeService {
    @Autowired
    XeRepository repository;

    public void save(Xe xe) {
        repository.save(xe);
    }

    public Xe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Xe> getAll() {
        return repository.findAll();
    }
}
