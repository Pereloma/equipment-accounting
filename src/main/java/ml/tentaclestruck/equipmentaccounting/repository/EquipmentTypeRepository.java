package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.Floor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EquipmentTypeRepository extends JpaRepositoryImplementation<EquipmentType, String> {
}
