package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "INVENTORY")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private EquipmentType equipmentType;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "found_equipment")
    private List<Equipment> foundEquipment;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "not_found_equipment")
    private List<Equipment> notFoundEquipment;



    @ManyToOne()
    User user;

    private Date date;


    public Inventory() {
        this.date = new Date();
        this.foundEquipment =new ArrayList<>();
        this.notFoundEquipment =new ArrayList<>();
    }
}
