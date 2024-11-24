package com.pms.controller;

import com.pms.model.Drug;
import com.pms.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drugs")
public class DrugController {

    @Autowired
    private DrugService drugService;
    
    @GetMapping("/")
    public String home() {
        return "redirect:/drugs";
    }

    @GetMapping
    public String getAllDrugs(Model model) {
        model.addAttribute("drugs", drugService.getAllDrugs());
        return "drug-list";
    }

    @PostMapping("/add")
    public String addDrug(@ModelAttribute Drug drug) {
        drugService.saveDrug(drug);
        return "redirect:/drugs";
    }

    @PostMapping("/update")
    public String updateDrug(@ModelAttribute Drug drug) {
        drugService.updateDrug(drug);
        return "redirect:/drugs";
    }

    @PostMapping("/deactivate")
    public String deactivateDrug(@RequestParam Long id) {
        drugService.deactivateDrug(id);
        return "redirect:/drugs";
    }
    @PostMapping("/delete")
    public String deleteDrug(@RequestParam Long id) {
        drugService.deleteDrug(id);
        return "redirect:/drugs";
    }
}