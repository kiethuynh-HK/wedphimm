package com.example.wedphimm.Controller;

import com.example.wedphimm.entity.ChiNhanh;
import com.example.wedphimm.service.ChiNhanhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chinhanhs")
public class ChiNhanhController {
    @Autowired
    private ChiNhanhService chinhanhService;

    @GetMapping
    public String showAllChiNhanh(Model model)
    {
        List<ChiNhanh> chinhanh =  chinhanhService.getAllChiNhanhs();
        model.addAttribute("chinhanhs", chinhanh);
        model.addAttribute("name","chinhanhs");
        return "chinhanh/list";
    }

    @GetMapping("/add")
    public String addChiNhanhForm(Model model){
        model.addAttribute("chinhanh",new ChiNhanh());
        return "chinhanh/add";
    }


    @PostMapping("/add")
    public String addChiNhanh(@Valid @ModelAttribute("chinhanh") ChiNhanh  chinhanh , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors())
        {

            return "chinhanh/add";
        }
        chinhanhService.createChiNhanh(chinhanh);
        return "redirect:/chinhanhs";
    }

    @GetMapping("/edit/{id}")
    public String editChiNhanhForm(@PathVariable("id") long id, Model model){
        ChiNhanh editCate =  chinhanhService.getChiNhanhById(id);
        if(editCate != null){
            model.addAttribute("chinhanh", editCate);
            return "chinhanh/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editChiNhanh(@Valid @ModelAttribute("chinhanh") ChiNhanh updateCate, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());
            return "chinhanh/edit";
        }
        chinhanhService.getAllChiNhanhs().stream()
                .filter(chinhanh -> chinhanh.getId() == updateCate.getId())
                .findFirst()
                .ifPresent( chinhanh -> {

                    chinhanhService.updateChiNhanh(updateCate);
                });
        return "redirect:/chinhanhs";
    }
    @PostMapping("/delete/{id}")
    public String deletePhong(@PathVariable("id") long id){
        chinhanhService.deleteChiNhanh(id);
        return "redirect:/chinhanhs";
    }
}
