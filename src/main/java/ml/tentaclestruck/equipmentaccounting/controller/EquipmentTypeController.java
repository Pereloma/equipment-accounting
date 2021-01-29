package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Floor;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentTypeRepository;
import ml.tentaclestruck.equipmentaccounting.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/EquipmentType")
public class EquipmentTypeController {
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @GetMapping("/new")
    public String newEquipmentType(Model model) {
        model.addAttribute("equipmentType", new EquipmentType());
        return "newEquipmentType";
    }

    @PostMapping("/put")
    public String putOrganization(@Valid EquipmentType equipmentType, Errors errors) {
        if (errors.hasErrors())
            return "redirect:/EquipmentType/new";
        equipmentTypeRepository.save(equipmentType);
        return "redirect:/";
    }
}
