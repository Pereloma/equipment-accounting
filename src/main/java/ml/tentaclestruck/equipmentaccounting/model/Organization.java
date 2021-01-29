package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "ORGANIZATION")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String name;

    private String abbreviation;

    private String address;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (abbreviation == null)
            result.append(name);
        else
            result.append(abbreviation).append('(').append(name).append(')');

        return result.toString();
    }
}
