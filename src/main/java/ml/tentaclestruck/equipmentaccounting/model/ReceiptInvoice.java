package ml.tentaclestruck.equipmentaccounting.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//приходная накладная
@Data
@Entity
@Table(name = "RECEIPT_INVOICE")
public class ReceiptInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Equipment> equipmentList;

    @ManyToOne
    private Organization provider;

    @ManyToOne()
    private User user;

    private Date date;

    public ReceiptInvoice() {
        this.equipmentList = new ArrayList<Equipment>();
        this.date = new Date();
    }
}
