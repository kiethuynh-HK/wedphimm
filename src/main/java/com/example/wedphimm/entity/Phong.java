package com.example.wedphimm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "phong")
public class Phong {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenphong")
    @NotEmpty(message = "Title must not be empty")
    /*@Size(max= 50 , min=1,message="Title must be less than 50 characters")*/
    private String tenphong;


    @Column(name = "maphong")
    private String maphong;


    @ManyToOne
    @JoinColumn(name = "chinhanh_id")
//    @ValidChiNhanhId
    private ChiNhanh chinhanh;


}
