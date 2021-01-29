package ml.tentaclestruck.equipmentaccounting.controller;

import ml.tentaclestruck.equipmentaccounting.model.Organization;
import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import ml.tentaclestruck.equipmentaccounting.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/Organization")
public class OrganizationController {
    @Autowired
    OrganizationRepository organizationRepository;

    @GetMapping("/new")
    public String newOrganization(Model model) {
        model.addAttribute("organization", new Organization());
        return "newOrganization";
    }

    @PostMapping("/put")
    public String putOrganization(@Valid Organization organization, Errors errors) {
        if (errors.hasErrors())
            return "redirect:/Organization/new";
        organizationRepository.save(organization);
        return "redirect:/";
    }
}
