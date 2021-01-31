package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    EquipmentService equipmentService;
    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("stockEquipment",equipmentService.getStockEquipment());
        return "home";
    }
}
