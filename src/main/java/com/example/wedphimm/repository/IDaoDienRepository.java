package com.example.wedphimm.repository;

import com.example.wedphimm.entity.DaoDien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDaoDienRepository extends JpaRepository<DaoDien,Long> {

}
