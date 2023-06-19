package com.example.wedphimm.repository;

import com.example.wedphimm.entity.ChiNhanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChiNhanhRepository extends JpaRepository<ChiNhanh,Long> {
}
