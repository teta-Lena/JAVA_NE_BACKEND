package rw.lena.ne.java_ne.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PurchaseDTO {

    @NotBlank
    private Long code;

    @NotNull
    private Integer quantity;
}