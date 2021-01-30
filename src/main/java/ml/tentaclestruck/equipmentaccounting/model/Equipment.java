package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "EQUIPMENT")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @Column(name = "inventory_number")
    private String inventoryNumber;

    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne
    private Storage storage;

    @ManyToOne()
    private EquipmentType type;

    public String toStringRu(){
        StringBuilder stringBuilder = new StringBuilder();
        if(type != null) {
            stringBuilder.append(type);
            stringBuilder.append(": ");
        }
        if(name != null)
            stringBuilder.append(name);
        if(inventoryNumber != null) {
            stringBuilder.append(" IN-");
            stringBuilder.append(inventoryNumber);
        }
        if(serialNumber != null) {
            stringBuilder.append(" SN-");
            stringBuilder.append(serialNumber);
        }
        if(storage != null) {
            stringBuilder.append("(");
            stringBuilder.append(storage);
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}