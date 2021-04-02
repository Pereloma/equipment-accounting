package ml.tentaclestruck.equipmentaccounting.controller.rest;

import ml.tentaclestruck.equipmentaccounting.model.Inventory;
import ml.tentaclestruck.equipmentaccounting.model.Storage;
import ml.tentaclestruck.equipmentaccounting.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class StorageRestController {

    @Autowired
    StorageRepository storageRepository;

    @GetMapping("/GetStorage")
    public List<Storage> GetStorage(){
        return storageRepository.findAll();
    }
}
