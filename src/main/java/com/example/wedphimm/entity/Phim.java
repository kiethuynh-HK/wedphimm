package com.example.wedphimm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenPhim")
    @NotEmpty(message = "Ten phim khong duoc de trong")
    private String tenPhim;
    @Column(name = "rated")
    private float rated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaiPhim_id")
    private LoaiPhim loaiPhims;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngonNgu_id")
    private NgonNgu ngonNgus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daoDien_id")
    private DaoDien daoDiens;
    @OneToMany(mappedBy = "phim",cascade= CascadeType.ALL)
    private List<Ve> ves;
}