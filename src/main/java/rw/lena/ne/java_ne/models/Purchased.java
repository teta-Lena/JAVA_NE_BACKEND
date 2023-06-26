package rw.lena.ne.java_ne.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.lena.ne.java_ne.models.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "purchased")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productCode")
    private Product product;

    @OneToOne
    @JoinColumn(name = "quantity_id")
    private Quantity productQuantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(name = "total")
    private double totalAmount;

    @Column(name = "date")
    private LocalDate purchaseDate;

    @PrePersist
    private void prePersist() {
        if (purchaseDate == null) {
            purchaseDate = LocalDate.now();
        }
    }
    public Purchased(Quantity productQuantity, Customer customer) {
        this.productQuantity = productQuantity;
        this.customer = customer;
    }


}
