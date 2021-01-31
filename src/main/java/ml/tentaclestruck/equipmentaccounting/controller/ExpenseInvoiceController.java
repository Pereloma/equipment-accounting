package ml.tentaclestruck.equipmentaccounting.controller;

import com.google.zxing.qrcode.QRCodeWriter;
import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.ExpenseInvoice;
import ml.tentaclestruck.equipmentaccounting.repository.*;
import ml.tentaclestruck.equipmentaccounting.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//расходная накладная.
@Controller
@RequestMapping("/ExpenseInvoice")
public class ExpenseInvoiceController {
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    ExpenseInvoiceRepository expenseInvoiceRepository;
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @GetMapping("/new")
    public String newExpenseInvoice(Model model) {
        ExpenseInvoice expenseInvoice = new ExpenseInvoice();
        expenseInvoice.getEquipmentList().add(new Equipment());
        List<Equipment> allEquipment = equipmentService.getStockEquipment();

        model.addAttribute("expenseInvoice",expenseInvoice);
        model.addAttribute("allEquipment",allEquipment);
        model.addAttribute("organizations",organizationRepository.findAll());
        return "newExpenseInvoice";
    }

    @PostMapping("/addEquipment")
    public String addEquipmentExpenseInvoice(@Valid ExpenseInvoice expenseInvoice, Errors errors, Model model) {
        expenseInvoice.getEquipmentList().add(new Equipment());
        List<Equipment> allEquipment = equipmentService.getStockEquipment();
        model.addAttribute("expenseInvoice",expenseInvoice);
        model.addAttribute("allEquipment",allEquipment);
        model.addAttribute("organizations",organizationRepository.findAll());
        return "newExpenseInvoice";
    }

    @PostMapping("/save")
    public String saveExpenseInvoice(@Valid ExpenseInvoice expenseInvoice, Errors errors) {
        if(errors.hasErrors())
            return "redirect:/ExpenseInvoice/edit";
        for (Equipment equipment : expenseInvoice.getEquipmentList()){

            equipmentService.saveEquipment(equipment);
        }
        expenseInvoiceRepository.save(expenseInvoice);
        return "redirect:/ExpenseInvoice/edit/"+expenseInvoice.getId();
    }

    @PostMapping("/edit")
    public String editExpenseInvoice(@Valid ExpenseInvoice expenseInvoice, Errors errors, Model model) {
        List<Equipment> allEquipment = equipmentService.getStockEquipment();
        model.addAttribute("expenseInvoice",expenseInvoice);
        model.addAttribute("allEquipment",allEquipment);
        model.addAttribute("organizations",organizationRepository.findAll());
        return "newExpenseInvoice";
    }

    @GetMapping("/edit/{id}")
    public String editExpenseInvoice(@PathVariable("id") Long id, Model model) {
        ExpenseInvoice expenseInvoice = expenseInvoiceRepository.findFirstById(id);
        List<Equipment> allEquipment = equipmentService.getStockEquipment();
        model.addAttribute("expenseInvoice",expenseInvoice);
        model.addAttribute("allEquipment",allEquipment);
        model.addAttribute("organizations",organizationRepository.findAll());
        return "newExpenseInvoice";
    }
}
