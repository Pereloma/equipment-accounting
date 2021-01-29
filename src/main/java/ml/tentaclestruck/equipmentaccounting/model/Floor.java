package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "FLOOR")
public class Floor {
        @Id
        @NotBlank
        @Size(min = 1)
        private String floor;

        @Override
        public String toString() {
                return floor;
        }
}
