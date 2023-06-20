package com.example.wedphimm.Controller;

import com.example.wedphimm.entity.DaoDien;
import com.example.wedphimm.entity.LoaiPhim;
import com.example.wedphimm.entity.NgonNgu;
import com.example.wedphimm.entity.Phim;
import com.example.wedphimm.repository.ILoaiPhimRepository;
import com.example.wedphimm.repository.INgonNguRepository;
import com.example.wedphimm.service.DaoDienService;
import com.example.wedphimm.service.PhimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/phims")
public class PhimController {
    @Autowired
    private PhimService phimService;
    @Autowired
    private DaoDienService daoDienService;
    @Autowired
    private INgonNguRepository ngonNguRepository;
    @Autowired
    private ILoaiPhimRepository loaiPhimRepository;
    @GetMapping
    public String showAllPhim(Model model)
    {
        List<Phim> phim = phimService.getAllPhim();
        model.addAttribute("phims",phim);
        model.addAttribute("tenPhim","phims");
        return "phim/list";
    }


    @GetMapping("/add")
    public String addPhimForm(Model model){
        model.addAttribute("daodiens",daoDienService.getAllDaoDien());
        model.addAttribute("ngonngus",ngonNguRepository.findAll());
        model.addAttribute("loaiphims",loaiPhimRepository.findAll());
        model.addAttribute("phim",new Phim());
        return "phim/add";
    }
    @PostMapping("/add")
    public String addPhim(@Valid @ModelAttribute("phim") Phim phim, BindingResult bindingResult, Model model ){

        if(bindingResult.hasErrors())
        {
            model.addAttribute("daodiens",daoDienService.getAllDaoDien());
            model.addAttribute("ngonngus",ngonNguRepository.findAll());
            model.addAttribute("loaiphims",loaiPhimRepository.findAll());
            return "phim/add";
        }
        phimService.addPhim(phim);
        return "redirect:/phims";


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
