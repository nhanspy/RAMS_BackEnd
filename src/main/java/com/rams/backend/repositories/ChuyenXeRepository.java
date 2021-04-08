package com.rams.backend.repositories;

import com.rams.backend.entities.ChuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, String> {

//    @Query(value = "")
//    Object getTheoTrong();
}
