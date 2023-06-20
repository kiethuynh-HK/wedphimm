package com.example.wedphimm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class NgonNgu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ngonNgu")
    private String ngonNgu;
    @OneToMany(mappedBy = "ngonNgus" , fetch = FetchType.LAZY)
    private List<Phim> listPhim;
}
