package com.example.wedphimm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class DaoDien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenDaoDien")
    @NotEmpty(message = "Ten dao dien khong duoc de trong")
    private String tenDaoDien;
    @Column(name = "moTa")
    @NotEmpty(message = "Mo ta khong duoc de trong")
    private String moTa;
    @OneToMany(mappedBy = "daoDiens" , fetch = FetchType.LAZY)
    private List<Phim> listPhim;
}