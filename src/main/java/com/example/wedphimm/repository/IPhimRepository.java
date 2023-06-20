package com.example.wedphimm.repository;

import com.example.wedphimm.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhimRepository extends JpaRepository<Phim,Long> {
}
