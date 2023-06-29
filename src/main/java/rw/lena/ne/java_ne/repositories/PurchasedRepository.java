package rw.lena.ne.java_ne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.models.Purchased;

import java.util.List;

public interface PurchasedRepository extends JpaRepository<Purchased,Long> {
    List<Purchased> findPurchasedByCustomer(Customer customer);

}
