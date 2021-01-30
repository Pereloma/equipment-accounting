package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Inventory;
import ml.tentaclestruck.equipmentaccounting.model.User;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentTypeRepository;
import ml.tentaclestruck.equipmentaccounting.repository.InventoryRepository;
import ml.tentaclestruck.equipmentaccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @GetMapping
    public String newInventory(@AuthenticationPrincipal User user, Model model){
        Inventory inventory = new Inventory();
        inventory.setNotFoundEquipment(equipmentService.getStockEquipment(inventory.getDate()));
        inventory.setUser(user);
        model.addAttribute("inventory",inventory);
        model.addAttribute("equipmentTypeList",equipmentTypeRepository.findAll());
        model.addAttribute("stockEquipmentList",equipmentService.getStockEquipment(inventory.getDate()));
        return "inventory";
    }
    @PostMapping
    public String newInventory(Inventory inventory, Model model){
        inventory.getNotFoundEquipment().removeIf(equipment -> {
            if (equipment == null) return true;
            return equipment.getId() == null;});

        model.addAttribute("inventory",inventory);
        model.addAttribute("equipmentTypeList",equipmentTypeRepository.findAll());

        model.addAttribute("stockEquipmentList",equipmentService.getStockEquipment(inventory.getDate()));
        return "inventory";
    }
}
