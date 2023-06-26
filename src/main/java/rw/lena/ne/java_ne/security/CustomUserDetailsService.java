package rw.lena.ne.java_ne.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rw.lena.ne.java_ne.exceptions.BadRequestException;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CustomerRepository userRepository;

    @Autowired
    public CustomUserDetailsService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDetails loadByUserId(Long id) {
        Customer user = this.userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserByUsername(String s) throws BadRequestException {
        Customer user = userRepository.findByEmailOrPhoneNumber(s, s).orElseThrow(() -> new UsernameNotFoundException("user not found with email or mobile of " + s));

        return UserPrincipal.create(user);
    }
}
