package com.rams.backend.services;

import com.rams.backend.entities.Ben;
import com.rams.backend.repositories.BenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenService {
    @Autowired
    BenRepository repository;

    public void save(Ben ben) {
        repository.save(ben);
    }

    public Ben get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Ben> getAll() {
        return repository.findAll();
    }
}
