package rw.lena.ne.java_ne.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rw.lena.ne.java_ne.security.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {

    @Email
    private  String email;

    @NotBlank
    private  String firstName;


    @NotBlank
    @Pattern(regexp = "[0-9]{9,10}", message = "Your phone is not a valid tel we expect 07***")
    private  String mobile;


    @ValidPassword
    private  String password;
}
