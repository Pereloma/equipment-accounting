package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.Organization;
import ml.tentaclestruck.equipmentaccounting.model.ReceiptInvoice;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface OrganizationRepository extends JpaRepositoryImplementation<Organization, Long> {
}
