package rw.lena.ne.java_ne.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"phone"})})
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

    public Customer(String firstName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

}
