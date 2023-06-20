package com.example.wedphimm.repository;

import com.example.wedphimm.entity.LoaiPhim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoaiPhimRepository extends JpaRepository<LoaiPhim,Long> {
}
