package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Floor;
import ml.tentaclestruck.equipmentaccounting.model.Organization;
import ml.tentaclestruck.equipmentaccounting.model.Storage;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentTypeRepository;
import ml.tentaclestruck.equipmentaccounting.repository.FloorRepository;
import ml.tentaclestruck.equipmentaccounting.repository.OrganizationRepository;
import ml.tentaclestruck.equipmentaccounting.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Settings")
public class SetingsController {
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    FloorRepository floorRepository;
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping("/{typeSettings}")
    public String openSettings(@PathVariable("typeSettings") String typeSettings, Model model) {
        model.addAttribute("typeSettings",typeSettings);
        switch (typeSettings){
            case "floor":
                model.addAttribute("floor", new Floor());
                break;
            case "storge":
                model.addAttribute("storage", new Storage());
                model.addAttribute("floors", floorRepository.findAll());
                break;
            case "organization":
                model.addAttribute("organization", new Organization());
                break;
            default:
                model.addAttribute("equipmentType", new EquipmentType());
                break;
        }




        return "settings";
    }
}
