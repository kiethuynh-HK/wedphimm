package com.example.wedphimm.Controller;

import com.example.wedphimm.entity.DaoDien;

import com.example.wedphimm.entity.Phong;
import com.example.wedphimm.model.daoDienForm;
import com.example.wedphimm.repository.IDaoDienRepository;
import com.example.wedphimm.service.DaoDienService;
import com.example.wedphimm.service.PhongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/daodiens")
public class DaoDienController {
    @Autowired
    private DaoDienService daoDienService;
    @Autowired
    private IDaoDienRepository daoDienRepository;

    @GetMapping
    public String showAllDaoDien(Model model){
        List<DaoDien> daodien = daoDienService.getAllDaoDien();
        model.addAttribute("daodiens",daodien);
        model.addAttribute("tenDaoDien","daodiens");
        return "daodien/list";
    }
        @GetMapping("/add")
    public String addDaoDienForm(Model model){
        model.addAttribute("daodien",new DaoDien());
        return "daodien/add";
    }


    @PostMapping("/add")
    public String addDaoDien(@Valid @ModelAttribute("daodien") DaoDien daoDien,BindingResult bindingResult,Model model ){

        if(bindingResult.hasErrors())
        {
            return "daodien/add";
        }
        daoDienService.addDaoDien(daoDien);
        return "redirect:/daodiens";


    }
    @GetMapping("/edit/{id}")
    public String editDaoDienForm(@PathVariable("id") Long id, Model model){
        DaoDien editDaoDien = daoDienService.getDaoDienyId(id);
        if(editDaoDien != null){
            model.addAttribute("daodien", editDaoDien);
            return "daodien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editDaoDien(@Valid @ModelAttribute("daodien") DaoDien updateDaoDien, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "phong/edit";
        }
        daoDienService.getAllDaoDien().stream()
                .filter(daoDien -> daoDien.getId() == daoDien.getId())
                .findFirst()
                .ifPresent(daoDien -> {

                    daoDienService.updateDaoDien(updateDaoDien);
                });
        return "redirect:/daodiens";
    }
    @PostMapping("/delete/{id}")
    public String deleteDaoDien(@PathVariable("id") Long id){
        daoDienService.deleteDaoDien(id);
        return "redirect:/daodiens";
    }
}
