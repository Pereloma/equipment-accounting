package ml.tentaclestruck.equipmentaccounting.controller.rest;

import ml.tentaclestruck.equipmentaccounting.controller.InventoryController;
import ml.tentaclestruck.equipmentaccounting.model.Inventory;
import ml.tentaclestruck.equipmentaccounting.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class InventoryRestController {
    @Autowired
    InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> GetInventory(){
        return inventoryRepository.findAll();
    }

    @PutMapping
    public Inventory GetInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
}
