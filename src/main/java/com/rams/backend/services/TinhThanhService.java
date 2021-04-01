package com.rams.backend.services;

import com.rams.backend.entities.LoaiTk;
import com.rams.backend.entities.TinhThanh;
import com.rams.backend.repositories.LoaiTkRepository;
import com.rams.backend.repositories.TinhThanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinhThanhService {
    @Autowired
    TinhThanhRepository repository;

    public void save(TinhThanh tinhThanh) {
        repository.save(tinhThanh);
    }

    public TinhThanh get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<TinhThanh> getAll() {
        return repository.findAll();
    }
}
