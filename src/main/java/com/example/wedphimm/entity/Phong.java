package com.example.wedphimm.entity;

//import com.example.wedphimm.Validator.annotation.ValidChiNhanhId;
//import com.example.wedphimm.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

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
    private ChiNhanh chinhanh;
    @OneToMany(mappedBy = "phong",cascade= CascadeType.ALL)
    private List<Ve> ves;



}
