package com.rams.backend.repositories;

import com.rams.backend.entities.ChuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, String> {
    @Query(value = "select * from chuyen_xe where DATE_FORMAT(thoi_gian, '%Y %m %d') = DATE_FORMAT(:ngay, '%Y %m %d')", nativeQuery = true)
    public List<ChuyenXe> getByNgay(@Param("ngay") String ngay);
}
