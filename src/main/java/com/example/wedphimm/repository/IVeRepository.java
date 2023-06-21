package com.example.wedphimm.repository;

import com.example.wedphimm.entity.Phong;
import com.example.wedphimm.entity.Ve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeRepository extends JpaRepository<Ve,Long> {
}
