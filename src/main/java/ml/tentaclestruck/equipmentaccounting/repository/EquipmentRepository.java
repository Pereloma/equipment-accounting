package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.Equipment;
import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface EquipmentRepository extends JpaRepositoryImplementation<Equipment, Long> {
    Equipment findFirstById (Long id);

    @Query(nativeQuery = true,
            value = "select equipment.* from equipment " +
                    "join receipt_invoice_equipment_list on equipment.id = receipt_invoice_equipment_list.equipment_list_id " +
                    "left join expense_invoice_equipment_list on equipment.id = expense_invoice_equipment_list.equipment_list_id " +
                    "left join inventory_not_found_equipment on equipment.id = inventory_not_found_equipment.inventory_id " +
                    "where expense_invoice_id is null " +
                    "and not_found_equipment_id is null")
    List<Equipment> getEquipmentsInStock();

    @Query(nativeQuery = true,
            value = "select equipment.* from equipment " +
                    "join receipt_invoice_equipment_list on equipment.id = receipt_invoice_equipment_list.equipment_list_id " +
                    "left join expense_invoice_equipment_list on equipment.id = expense_invoice_equipment_list.equipment_list_id " +
                    "left join inventory_not_found_equipment on equipment.id = inventory_not_found_equipment.inventory_id " +
                    "where expense_invoice_id is null " +
                    "and not_found_equipment_id is null " +
                    "and equipment.type_name = ?1")
    List<Equipment> getEquipmentsByType(EquipmentType type);
}
