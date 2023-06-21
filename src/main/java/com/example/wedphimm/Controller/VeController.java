package com.example.wedphimm.Controller;

import com.example.wedphimm.entity.Phong;
import com.example.wedphimm.entity.Ve;
import com.example.wedphimm.service.ChiNhanhService;
import com.example.wedphimm.service.PhimService;
import com.example.wedphimm.service.PhongService;
import com.example.wedphimm.service.VeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/ves")
public class VeController {
    @Autowired
    private PhongService phongService;
    @Autowired
    private ChiNhanhService chinhanhService;
    @Autowired
    private PhimService phimService;

    @Autowired
    private VeService veService;
    @GetMapping
    public String showAllVe(Model model) {
        List<Ve> ve = veService.getAllVe();
        model.addAttribute("ves", ve);

        return "ve/list";
    }


    @GetMapping("/add")
    public String addVeForm(Model model) {
        model.addAttribute("ve", new Ve());
        model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());
        model.addAttribute("phongs", phongService.getAllPhong());
        model.addAttribute("phims", phimService.getAllPhim());

        return "ve/add";
    }


    @PostMapping("/add")
    public String addVe(@Valid @ModelAttribute("ve") Ve ve, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());
            model.addAttribute("phongs", phongService.getAllPhong());
            model.addAttribute("phims", phimService.getAllPhim());

            return "ve/add";
        }
        veService.addVe(ve);
        return "redirect:/ves";
    }

    @GetMapping("/edit/{id}")
    public String editVeForm(@PathVariable("id") long id, Model model) {
        Ve editVe = veService.getVeById(id);
        if (editVe != null) {
            model.addAttribute("ve", editVe);
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());
            model.addAttribute("phongs", phongService.getAllPhong());
            model.addAttribute("phims", phimService.getAllPhim());

            return "ve/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editVe(@Valid @ModelAttribute("ve") Ve updateVe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("chinhanhs", chinhanhService.getAllChiNhanhs());
            model.addAttribute("phongs", phongService.getAllPhong());
            model.addAttribute("phims", phimService.getAllPhim());

            return "ve/edit";
        }
        veService.getAllVe().stream()
                .filter(ve-> ve.getId() == updateVe.getId())
                .findFirst()
                .ifPresent(ve -> {

                    veService.updateVe(updateVe);
                });
        return "redirect:/ves";
    }

    @PostMapping("/delete/{id}")
    public String deleteVe(@PathVariable("id") long id) {
        veService.deleteVe(id);
        return "redirect:/ves";
    }
}
