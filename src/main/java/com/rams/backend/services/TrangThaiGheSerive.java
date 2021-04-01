package com.rams.backend.services;

import com.rams.backend.entities.TinhThanh;
import com.rams.backend.entities.TrangThaiGhe;
import com.rams.backend.repositories.TinhThanhRepository;
import com.rams.backend.repositories.TrangThaiGheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrangThaiGheSerive{
    @Autowired
    TrangThaiGheRepository repository;

    public void save(TrangThaiGhe trangThaiGhe) {
        repository.save(trangThaiGhe);
    }

    public TrangThaiGhe get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<TrangThaiGhe> getAll() {
        return repository.findAll();
    }
}
