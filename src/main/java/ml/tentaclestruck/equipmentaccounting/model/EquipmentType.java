package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "EQUIPMENT_TYPE")
public class EquipmentType {
    @Id
    @NotBlank
    @Size(min = 1)
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
