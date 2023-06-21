package com.example.wedphimm.repository;


import com.example.wedphimm.entity.NgonNgu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INgonNguRepository extends JpaRepository<NgonNgu,Long> {
}