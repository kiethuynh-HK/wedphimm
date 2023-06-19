package com.example.wedphimm.repository;

import com.example.wedphimm.entity.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongRepository extends JpaRepository<Phong,Long> {
}
