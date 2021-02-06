package ml.tentaclestruck.equipmentaccounting.controller.rest;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Floor;
import ml.tentaclestruck.equipmentaccounting.model.Organization;
import ml.tentaclestruck.equipmentaccounting.model.Storage;
import ml.tentaclestruck.equipmentaccounting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class testController {
    @Autowired
    FloorRepository floorRepository;
    @Autowired
    StorageRepository storageRepository;
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("test")
    public String create(){
        Floor floor;
        Storage storage;
        for (int i = 1; i <= 3; i++) {
            floor = new Floor();
            floor.setFloor(String.valueOf(i));
            floorRepository.save(floor);
            for (int j = 1; j <= 5; j++) {
                storage = new Storage();
                storage.setFloor(floor);
                storage.setCabinet(String.valueOf((i*100)+j));
                storageRepository.save(storage);
            }
        }

        Organization organization = new Organization();
        organization.setName("Филиал Западносибирский ООО \"ДНС Ритейл\"");
        organization.setAbbreviation("DNS");
        organization.setAddress("г. Прокопьевск, Шахтеров проспект, д. 10");
        organizationRepository.save(organization);

        organization = new Organization();
        organization.setName("Сервисный центр ИП Плотицын Е.С.");
        organization.setAbbreviation("ИП Плотицын");
        organization.setAddress("г. Прокопьевск, ул Ноградская, д. 28 А");
        organizationRepository.save(organization);

        organization = new Organization();
        organization.setName("ДОБРОВОЛЕЦ");
        organization.setAddress("Г ПРОКОПЬЕВСК, ПРОСП ШАХТЕРОВ,Д 21");
        organizationRepository.save(organization);

        EquipmentType type = new EquipmentType();
        type.setName("ПК");
        equipmentTypeRepository.save(type);

        type = new EquipmentType();
        type.setName("Принтер");
        equipmentTypeRepository.save(type);

        type = new EquipmentType();
        type.setName("Монитор");
        equipmentTypeRepository.save(type);

        return "create!";
        }

    @GetMapping("testt")
    public String creatfe() {
        EquipmentType type = equipmentTypeRepository.findFirstByName("ПК");
    return equipmentRepository.getEquipmentsByType(type).toString();
    }
}
