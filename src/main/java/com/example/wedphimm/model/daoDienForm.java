package com.example.wedphimm.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class daoDienForm {
    private Long id;
    private String tenDaoDien;
    private String moTa;
    private MultipartFile image;
}
