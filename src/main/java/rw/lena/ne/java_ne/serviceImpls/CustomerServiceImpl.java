package rw.lena.ne.java_ne.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.exceptions.BadRequestException;
import rw.lena.ne.java_ne.exceptions.ResourceNotFoundException;
import rw.lena.ne.java_ne.repositories.CustomerRepository;
import rw.lena.ne.java_ne.services.CustomerService;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository userRepository;

    @Autowired
    public CustomerServiceImpl( CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Customer create(Customer user) {
        validateNewRegistration(user);

        return this.userRepository.save(user);
    }

    @Override
    public boolean isNotUnique(Customer user) {
        Optional<Customer> userOptional = this.userRepository.findByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber());
        return userOptional.isPresent();
    }

    @Override
    public void validateNewRegistration(Customer user) {
        if (isNotUnique(user)) {
            throw new BadRequestException(String.format("Customer with such credentials already exists"));
        }
    }

    @Override
    public Customer getLoggedInCustomer() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser")
            throw new BadRequestException("You are not logged in, try to log in");

        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", email));
    }
}
