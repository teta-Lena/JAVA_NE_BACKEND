package rw.lena.ne.java_ne.services;

import rw.lena.ne.java_ne.dtos.QuantityDTO;
import rw.lena.ne.java_ne.models.Product;
import rw.lena.ne.java_ne.models.Quantity;

import java.util.List;

public interface QuantityService {

    public Quantity addQuantity(Quantity qty);

    List<Quantity> getAllQuantities();
    boolean isExistsByQuantity(Quantity quantity);
    public Quantity updateQuantity(Quantity qty);

    Quantity findByProductCode(Long productCode);
}
