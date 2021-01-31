package ml.tentaclestruck.equipmentaccounting.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import ml.tentaclestruck.equipmentaccounting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/ReceiptInvoice")
public class ReceiptInvoiceController {
    @Autowired
    ReceiptInvoiceRepository receiptInvoiceRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    QRCodeWriter barcodeWriter;

    @GetMapping("/new")
    public String newReceiptInvoice(Model model){
        ReceiptInvoice receiptInvoice = new ReceiptInvoice();
        receiptInvoice.getEquipmentList().add(new Equipment());

        model.addAttribute("receiptInvoice",receiptInvoice);
        model.addAttribute("organizations",organizationRepository.findAll());
        model.addAttribute("storages",storageRepository.findAll());
        model.addAttribute("equipmentTypes",equipmentTypeRepository.findAll());
        return "newReceiptInvoice";
    }
    @PostMapping("/save")
    public String saveReceiptInvoice(@Valid ReceiptInvoice receiptInvoice, Errors errors){
        if (errors.hasErrors())
            return "redirect:/ReceiptInvoice/edit";

        equipmentRepository.saveAll(receiptInvoice.getEquipmentList());
        receiptInvoiceRepository.save(receiptInvoice);
        return "redirect:/ReceiptInvoice/edit/"+receiptInvoice.getId();
    }

    @GetMapping("/edit/")
    public String editReceiptInvoice(@Valid ReceiptInvoice receiptInvoice, Errors errors, Model model){
        model.addAttribute("receiptInvoice",receiptInvoice);
        model.addAttribute("organizations",organizationRepository.findAll());
        model.addAttribute("storages",storageRepository.findAll());
        model.addAttribute("equipmentTypes",equipmentTypeRepository.findAll());
        return "newReceiptInvoice";
    }
    @GetMapping("/edit/{id}")
    public String editReceiptInvoice(@PathVariable("id") Long id, Model model){
        model.addAttribute("receiptInvoice",receiptInvoiceRepository.findFirstById(id));
        model.addAttribute("organizations",organizationRepository.findAll());
        model.addAttribute("storages",storageRepository.findAll());
        model.addAttribute("equipmentTypes",equipmentTypeRepository.findAll());
        return "newReceiptInvoice";
    }

    @PostMapping("/addEquipment")
    public String newEquipmentReceiptInvoice(@Valid ReceiptInvoice receiptInvoice, Errors errors, Model model){
        receiptInvoice.getEquipmentList().add(new Equipment());

        model.addAttribute("receiptInvoice",receiptInvoice);
        model.addAttribute("organizations",organizationRepository.findAll());
        model.addAttribute("storages",storageRepository.findAll());
        model.addAttribute("equipmentTypes",equipmentTypeRepository.findAll());
        return "newReceiptInvoice";
    }


    @GetMapping("/print")
    public String printReceiptInvoice(@RequestParam Long id, Model model){
        if (id != null) {
            ReceiptInvoice receiptInvoice = receiptInvoiceRepository.findFirstById(id);
            if(receiptInvoice.getId()!=null) {
                model.addAttribute("receiptInvoice", receiptInvoice);
                model.addAttribute("organizations", organizationRepository.findAll());
                model.addAttribute("storages", storageRepository.findAll());
                model.addAttribute("equipmentTypes", equipmentTypeRepository.findAll());

                return "printReceiptInvoice";
            }
        }
        return "redirect:/ReceiptInvoice/new";
    }

    @GetMapping(value = "/QR/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueQR(@PathVariable("barcode") String barcode) throws WriterException {
        BitMatrix bitMatrix = barcodeWriter.encode(barcode, BarcodeFormat.QR_CODE, 100, 100);
        return ResponseEntity.ok(MatrixToImageWriter.toBufferedImage(bitMatrix));
    }

}
