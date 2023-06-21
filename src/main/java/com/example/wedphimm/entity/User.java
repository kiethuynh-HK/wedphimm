//package com.example.wedphimm.entity;
//
//import com.example.wedphimm.Validator.annotation.ValidUsername;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//
//import java.util.*;
//
//@Data
//@Entity
//@Table(name = "user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "username", length = 50, nullable = false, unique = true)
//    @NotBlank(message = "Username is required")
//    @Size(max = 50, message = "Username must be less than 50 characters")
//    @ValidUsername
//    private String username;
//    @Column(name = "password", length = 250, nullable = false)
//    @NotBlank(message = "Password is required")
//    private String password;
////    @Column(name = "name", length = 50, nullable = false)
////    @Size(max = 50, message = "Your name must be less than 50 characters")
////    @NotBlank(message = "Your name is required")
////    private String name;
//    @Column(name="DiaChi")
//    @NotBlank(message = "Your place is required")
//    @Size(min = 1,max = 200)
//    private String DiaChi;
//    @Column(name="sdt")
//    @NotBlank(message = "Your phone is required")
//    @Size(min = 10,max = 10)
//    private String sdt;
//    @Column(name = "email", length = 50)
//    @NotBlank(message = "Your email is required")
//    @Size(max = 50, message = "Email must be less than 50 characters")
//    private String email;
////    @Column(name="ngaySinh")
////    @NotBlank(message = "Your date is required")
////    private Date ngaySinh;
//
//    @ManyToMany
//    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Phong> phongs = new ArrayList<>();
//}
