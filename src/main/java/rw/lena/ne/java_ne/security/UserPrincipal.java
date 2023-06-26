package rw.lena.ne.java_ne.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rw.lena.ne.java_ne.models.Customer;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private Long id;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String password;



    public static UserPrincipal create(Customer customer) {
        return new UserPrincipal(
                customer.getId(),
                customer.getFirstName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getPassword());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
