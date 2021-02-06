package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//расходная накладная.
@Data
@Entity
@Table(name = "EXPENSE_INVOICE")
public class ExpenseInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    List<Equipment> equipmentList;

    @ManyToOne
    private Organization organization;

    @ManyToOne()
    private User user;

    private Date date;

    public ExpenseInvoice() {
        this.equipmentList = new ArrayList<>();
    }
}
