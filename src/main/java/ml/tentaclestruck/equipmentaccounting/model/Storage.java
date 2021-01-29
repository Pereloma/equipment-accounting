package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "STORAGE")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Floor floor;

    @NotBlank
    @Column(nullable = false)
    private String cabinet;

    public String toStringRu() {
        return "этаж=" + floor +
                ", кабинет=" + cabinet;
    }
}
