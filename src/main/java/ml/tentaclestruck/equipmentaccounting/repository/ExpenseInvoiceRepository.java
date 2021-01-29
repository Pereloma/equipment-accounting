package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.EquipmentType;
import ml.tentaclestruck.equipmentaccounting.model.ExpenseInvoice;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ExpenseInvoiceRepository extends JpaRepositoryImplementation<ExpenseInvoice, Long> {
    ExpenseInvoice findFirstById(Long id);
}
