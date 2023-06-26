package rw.lena.ne.java_ne.services;



import rw.lena.ne.java_ne.dtos.PurchaseDTO;
import rw.lena.ne.java_ne.models.Purchased;

import java.util.List;

public interface PurchasedService {

    List<Purchased> byLoggedInCustomer();

    List<Purchased> all();

    Purchased purchase(PurchaseDTO dto);
}
