package rw.lena.ne.java_ne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.models.Product;
import rw.lena.ne.java_ne.models.Purchased;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchasedRepository extends JpaRepository<Purchased,Long> {

    Optional<Purchased> findByProductCode(UUID productCode);
    Optional<Purchased> findByProductCodeAndQuantity(UUID productCode, double quantity);
    Optional<Purchased> findByProductCodeAndQuantityAndTotalAmount(UUID productCode,double quantity, double totalAmount);
    List<Purchased> findByCustomer(Customer customer);
}