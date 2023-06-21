package com.example.wedphimm.repository;

import com.example.wedphimm.entity.LichChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILichChieuRepository extends JpaRepository<LichChieu,Long> {
}