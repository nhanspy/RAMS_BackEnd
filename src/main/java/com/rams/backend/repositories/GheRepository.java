package com.rams.backend.repositories;

import com.rams.backend.entities.Ghe;
import com.rams.backend.entities.Xe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GheRepository extends JpaRepository<Ghe, String> {
    List<Ghe> findAllByXe(Xe xe);
    Ghe findGheByMaGhe(String maGhe);
    Ghe findGheByVeXes(String maVe);
}
