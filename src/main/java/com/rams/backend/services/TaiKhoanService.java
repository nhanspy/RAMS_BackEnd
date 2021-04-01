package com.rams.backend.services;

import com.rams.backend.entities.LoaiTk;
import com.rams.backend.entities.TaiKhoan;
import com.rams.backend.repositories.LoaiTkRepository;
import com.rams.backend.repositories.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanService {
    @Autowired
    TaiKhoanRepository repository;

    public void save(TaiKhoan taiKhoan) {
        repository.save(taiKhoan);
    }

    public TaiKhoan get(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<TaiKhoan> getAll() {
        return repository.findAll();
    }
}
