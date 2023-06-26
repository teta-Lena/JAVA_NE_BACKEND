package rw.lena.ne.java_ne.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String name;

    private String productType;

    private double price;


    private LocalDate inDate;


    @PrePersist
    private void prePersist() {
        if (inDate == null) {
            inDate = LocalDate.now();
        }
    }


}
