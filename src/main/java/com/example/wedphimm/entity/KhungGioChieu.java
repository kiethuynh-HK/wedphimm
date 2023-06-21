package com.example.wedphimm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class KhungGioChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer gioBatDau;
    @Column
    private String moTa;

}