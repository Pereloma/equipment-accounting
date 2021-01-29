package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.web.bind.annotation.RestController;

public interface ReceiptInvoiceRepository extends JpaRepositoryImplementation<ReceiptInvoice, Long> {
    ReceiptInvoice findFirstById (Long id);
}
