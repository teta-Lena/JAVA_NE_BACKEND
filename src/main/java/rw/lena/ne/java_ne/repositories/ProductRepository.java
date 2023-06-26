package rw.lena.ne.java_ne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.lena.ne.java_ne.models.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(Long code  );

    Optional<Product> findProductByName(String name);
    Optional<Product> findProductByProductType(String type);
    Optional<Product> findProductByNameAndProductType(String name, String type);
    Optional<Product> findProductByNameAndProductTypeAndPrice(String name, String type, double price);
    Optional<Product> findProductByPriceAndName(String name,double price);
    Optional<Product> findProductByPrice(double price);

}
