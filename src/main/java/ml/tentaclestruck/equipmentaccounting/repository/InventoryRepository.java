package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.Inventory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface InventoryRepository extends JpaRepositoryImplementation<Inventory, Long> {
}
