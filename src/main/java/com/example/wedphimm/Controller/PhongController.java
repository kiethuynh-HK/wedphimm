package com.example.wedphimm.Controller;


import com.example.wedphimm.entity.Phong;

import com.example.wedphimm.service.ChiNhanhService;

import com.example.wedphimm.service.PhongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phongs")
public class PhongController {
    @Autowired
    private PhongService phongService;
    @Autowired
    private ChiNhanhService chinhanhService;



    @GetMapping
    public String showAllPhong(Model model)
    {
        List<Phong> phong = phongService.getAllPhong();
        model.addAttribute("phongs",phong);
        model.addAttribute("tenphong","phongs");
        return "phong/list";
    }


    @GetMapping("/add")
    public String addPhongForm(Model model){
        model.addAttribute("phong",new Phong());
        model.addAttribute("chinhanhs",chinhanhService.getAllChiNhanhs());

        return "phong/add";
    }


    @PostMapping("/add")
    public String addPhong(@Valid @ModelAttribute("phong") Phong phong , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("chinhanhs",chinhanhService.getAllChiNhanhs());

            return "phong/add";
        }
        phongService.addPhong(phong);
        return "redirect:/phongs";
    }
    @GetMapping("/edit/{id}")
    public String editPhongForm(@PathVariable("id") long id, Model model){
        Phong editPhong = phongService.getPhongById(id);
        if(editPhong != null){
            model.addAttribute("phong", editPhong);
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());

            return "phong/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editPhong(@Valid @ModelAttribute("phong") Phong updatePhong, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());

            return "phong/edit";
        }
        phongService.getAllPhong().stream()
                .filter(phong -> phong.getId() == updatePhong.getId())
                .findFirst()
                .ifPresent(phong -> {

                    phongService.updatePhong(updatePhong);
                });
        return "redirect:/phongs";
    }
    @PostMapping("/delete/{id}")
    public String deletePhong(@PathVariable("id") Long id){
        phongService.deletePhong(id);
        return "redirect:/phongs";
    }
//    private Long id_;
//    @GetMapping("/addghe/{id}")
//    public String gheForm(@PathVariable("id") Long id, Model model){
//        Phong editPhong = phongService.getPhongById(id);
//        if(editPhong != null){
//            id_=id;
//            return "phong/addGhe";
//        }else {
//            return "not-found";
//        }
//    }
//    @PostMapping("/addghe")
//    public String ghe(Long soghe, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "phong/addGhe";
//        }
//        if(soghe!=null){
//            for(Integer i=0;i<soghe;i++){
//                Ghe ghe=new Ghe();
//                ghe.setTenghe("Ghế: "+(i+1));
//                Phong phong=phongService.getPhongById(id_);
//                ghe.setPhongs(phong);
//                gheService.addGhe(ghe);
//            }
//        }
//        return "redirect:/phongs";
//    }

}
