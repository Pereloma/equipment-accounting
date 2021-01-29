package ml.tentaclestruck.equipmentaccounting.repository;

import ml.tentaclestruck.equipmentaccounting.model.Floor;
import ml.tentaclestruck.equipmentaccounting.model.Organization;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface FloorRepository extends JpaRepositoryImplementation<Floor, String> {
}
