package com.rams.backend.repositories;

import com.rams.backend.entities.VeXe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeXeRepository extends JpaRepository<VeXe, String> {

    List<VeXe> getAllByCode(String code);
    VeXe findByCode(String code);
}
