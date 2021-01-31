package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Equipment")

public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/{id}")
    public String getHome(@PathVariable("id") Long id, Model model){
        if(id != null){
            Equipment equipment = equipmentService.findFirstById(id);
            model.addAttribute("equipment", equipment);
            model.addAttribute("receiptInvoice", equipmentService.getReceiptInvoice(equipment));
            model.addAttribute("inventoryList", equipmentService.getInventory(equipment));
            return "equipment";
        }
        return "redirect:/";
    }
}
