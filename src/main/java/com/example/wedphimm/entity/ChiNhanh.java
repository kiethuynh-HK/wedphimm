package com.example.wedphimm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "chinhanh")
public class ChiNhanh {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="diachi")
    private String diachi;
    @OneToMany(mappedBy = "chinhanh",cascade= CascadeType.ALL)
    private List<Phong> phongs;
    @OneToMany(mappedBy = "chinhanh",cascade= CascadeType.ALL)
    private List<Ve> ves;
}
