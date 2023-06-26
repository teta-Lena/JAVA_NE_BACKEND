package rw.lena.ne.java_ne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.lena.ne.java_ne.models.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailOrPhoneNumber(String email, String phoneNumber);


}
