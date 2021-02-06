package ml.tentaclestruck.equipmentaccounting.service;

import ml.tentaclestruck.equipmentaccounting.model.*;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentRepository;
import ml.tentaclestruck.equipmentaccounting.repository.ExpenseInvoiceRepository;
import ml.tentaclestruck.equipmentaccounting.repository.InventoryRepository;
import ml.tentaclestruck.equipmentaccounting.repository.ReceiptInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Equipment> getStockEquipment(){
        return equipmentRepository.getEquipmentsInStock();
    }

    public List<Equipment> getStockEquipment(Date date){
        List<Equipment> equipmentList = new ArrayList<>();
        for (ReceiptInvoice receiptInvoice:receiptInvoiceRepository.findAll()){
            equipmentList.addAll(receiptInvoice.getEquipmentList());
        }
        for (ExpenseInvoice expenseInvoice : expenseInvoiceRepository.findAll()){
            equipmentList.removeAll(expenseInvoice.getEquipmentList());
        }
        for (Inventory inventory : inventoryRepository.findAll()){
            equipmentList.removeAll(inventory.getNotFoundEquipment());
        }
        return equipmentList;
    }

    public List<Equipment> getStockEquipment(EquipmentType equipmentType){

        return equipmentRepository.getEquipmentsByType(equipmentType);
    }

    public List<Equipment> getStockEquipment(Date date, EquipmentType equipmentType){
        List<Equipment> equipmentList = new ArrayList<>();

        for (ReceiptInvoice receiptInvoice:receiptInvoiceRepository.findAll()){
            for(Equipment equipment : receiptInvoice.getEquipmentList()){
                if (equipment.getType().equals(equipmentType)){
                    equipmentList.add(equipment);
                }
            }
        }
        for (ExpenseInvoice expenseInvoice : expenseInvoiceRepository.findAll()){
            equipmentList.removeAll(expenseInvoice.getEquipmentList());
        }
        for (Inventory inventory : inventoryRepository.findAll()){
            equipmentList.removeAll(inventory.getNotFoundEquipment());
        }
        return equipmentList;
    }


    public Equipment findFirstById(Long id){
        return equipmentRepository.findFirstById(id);
    }

    public ReceiptInvoice getReceiptInvoice (Equipment equipment){
        for (ReceiptInvoice receiptInvoice : receiptInvoiceRepository.findAll()){
            if(receiptInvoice.getEquipmentList().contains(equipment))
                return receiptInvoice;
        }
        return null;
    }

    public List<Inventory> getInventory (Equipment equipment){
        List<Inventory> re = new ArrayList<>();
        for (Inventory inventory : inventoryRepository.findAll()){
            if(inventory.getFoundEquipment().contains(equipment))
                re.add(inventory);
        }
        return re;
    }

    public Equipment saveEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }


}
