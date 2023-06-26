package rw.lena.ne.java_ne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.lena.ne.java_ne.models.Quantity;

import java.util.Optional;
import java.util.UUID;

public interface QuantityRepository extends JpaRepository<Quantity,Long> {

    Optional<Quantity> findByProductCode(Long productCode);
    Optional<Quantity> findByOperationAndQuantity(String operation,int quantity);
    Optional<Quantity> findByOperation(String operation);
    Optional<Quantity> findByQuantityAndProductCode(int quantity, Long productCode);

}
