package com.example.wedphimm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "ve")
public class Ve {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phim_id")
    private Phim phim;
    @ManyToOne
    @JoinColumn(name = "chinhanh_id")
    private ChiNhanh chinhanh;
    @ManyToOne
    @JoinColumn(name = "phong_id")
    private Phong phong;
}
