package ml.tentaclestruck.equipmentaccounting.service;

import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.ExpenseInvoice;
import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentRepository;
import ml.tentaclestruck.equipmentaccounting.repository.ExpenseInvoiceRepository;
import ml.tentaclestruck.equipmentaccounting.repository.ReceiptInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    ExpenseInvoiceRepository expenseInvoiceRepository;
    @Autowired
    ReceiptInvoiceRepository receiptInvoiceRepository;

    public List<Equipment> getStockEquipment(){
        List<Equipment> equipmentList = new ArrayList<>();
        for (ReceiptInvoice receiptInvoice:receiptInvoiceRepository.findAll()){
            equipmentList.addAll(receiptInvoice.getEquipmentList());
        }
        for (ExpenseInvoice expenseInvoice : expenseInvoiceRepository.findAll()){
            equipmentList.removeAll(expenseInvoice.getEquipmentList());
        }
        return equipmentList;
    }

    public List<Equipment> getStockEquipment(Date date){
        List<Equipment> equipmentList = new ArrayList<>();
        for (ReceiptInvoice receiptInvoice:receiptInvoiceRepository.findAll()){
            equipmentList.addAll(receiptInvoice.getEquipmentList());
        }
        for (ExpenseInvoice expenseInvoice : expenseInvoiceRepository.findAll()){
            equipmentList.removeAll(expenseInvoice.getEquipmentList());
        }
        return equipmentList;
    }
    public Equipment findFirstById(Long id){
        return equipmentRepository.findFirstById(id);
    }
}
