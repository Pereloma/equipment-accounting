package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.Floor;
import ml.tentaclestruck.equipmentaccounting.model.Organization;
import ml.tentaclestruck.equipmentaccounting.repository.FloorRepository;
import ml.tentaclestruck.equipmentaccounting.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/Floor")
public class FloorController {
    @Autowired
    FloorRepository floorRepository;

    @GetMapping("/new")
    public String newFloor(Model model) {
        model.addAttribute("floor", new Floor());
        return "newFloor";
    }

    @PostMapping("/put")
    public String putOrganization(@Valid Floor floor, Errors errors) {
        if (errors.hasErrors())
            return "redirect:/Floor/new";
        floorRepository.save(floor);
        return "redirect:/";
    }

}
