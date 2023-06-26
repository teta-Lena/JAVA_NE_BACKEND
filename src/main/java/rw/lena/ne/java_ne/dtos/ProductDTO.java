package rw.lena.ne.java_ne.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank
    private  String name;

    @NotBlank
    private  String type;

    @NotNull
    private  Double price;
}
