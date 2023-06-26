package rw.lena.ne.java_ne.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.lena.ne.java_ne.dtos.QuantityDTO;
import rw.lena.ne.java_ne.enums.productOperation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "quantity")
@NoArgsConstructor
@AllArgsConstructor
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "productCode")
    private Product product;

    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation")
    private productOperation operation;
    private LocalDate date;

    public Quantity(int quantity,productOperation op, Product product) {
        this.product = product;
        this.quantity = quantity;
        this.operation = op;
    }


    @PrePersist
    private void prePersist() {
        if (date == null) {
            date = LocalDate.now();
        }
    }
}
