package com.rams.backend.services;

import com.rams.backend.entities.Ben;
import com.rams.backend.repositories.BenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Ben> getAllByTinhThanh(String id) {
        List<Ben> bens =  repository.findAll();
        List<Ben> bensResult = new ArrayList<Ben>();
        for (Ben ben :
                bens) {
            if (ben.getTinhThanh().getMaTinh().equals(id)) bensResult.add(ben);
        }
        return bensResult;
    }

}
