package rw.lena.ne.java_ne.services;



import rw.lena.ne.java_ne.dtos.PurchaseDTO;
import rw.lena.ne.java_ne.models.Purchased;

import java.util.List;

public interface PurchasedService {

    List<Purchased> byAuthenticatedCustomer();

    List<Purchased> getAllPurchasedProducts();

    Purchased purchase(PurchaseDTO dto);

    //add pagination if cart is too long
}
