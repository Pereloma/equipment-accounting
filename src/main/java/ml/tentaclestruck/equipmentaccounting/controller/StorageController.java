package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.Storage;
import ml.tentaclestruck.equipmentaccounting.repository.FloorRepository;
import ml.tentaclestruck.equipmentaccounting.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
@RequestMapping("/Storage")
public class StorageController {
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    FloorRepository floorRepository;

    @GetMapping("/new")
    public String newStorage(Model model) {
        model.addAttribute("storage", new Storage());
        model.addAttribute("floors", floorRepository.findAll());
        return "newStorage";
    }

    @PostMapping("/put")
    public String putStorage(@Valid Storage storage, Errors errors) {
        if (errors.hasErrors())
            return "redirect:/Storage/new";
        storageRepository.save(storage);
        return "redirect:/";
    }
}
