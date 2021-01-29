package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import ml.tentaclestruck.equipmentaccounting.model.Storage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface StorageRepository extends JpaRepositoryImplementation<Storage, Long> {
}
