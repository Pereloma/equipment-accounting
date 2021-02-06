package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private EquipmentType equipmentType;

    @OneToMany()
    private List<Equipment> foundEquipment;

    @OneToMany()
    private List<Equipment> notFoundEquipment;

    @ManyToOne()
    private User user;

    private Date date;


    public Inventory() {
        this.date = new Date();
        this.foundEquipment =new ArrayList<>();
        this.notFoundEquipment =new ArrayList<>();
    }
}
