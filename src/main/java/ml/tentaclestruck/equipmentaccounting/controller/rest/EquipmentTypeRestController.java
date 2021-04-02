package ml.tentaclestruck.equipmentaccounting.controller.rest;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Storage;
import ml.tentaclestruck.equipmentaccounting.repository.EquipmentTypeRepository;
import ml.tentaclestruck.equipmentaccounting.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/API")
public class EquipmentTypeRestController {

    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;

    @GetMapping("/GetEquipmentType")
    public List<EquipmentType> GetEquipmentType(){
        return equipmentTypeRepository.findAll();
    }
}
