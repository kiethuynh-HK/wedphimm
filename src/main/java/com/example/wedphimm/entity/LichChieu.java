package com.example.wedphimm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class LichChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String moTa;
    @Column
    private Date ngayChieu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gioChieu_id")
    private KhungGioChieu gioChieu;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phong_id")
    private Phong phong;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "phim_id")
    private Phim phim;
}
