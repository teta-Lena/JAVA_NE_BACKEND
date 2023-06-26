package rw.lena.ne.java_ne.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.lena.ne.java_ne.enums.productOperation;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

//    @NotNull(message = "Product code must be provided")
    private Long productCode;
    @NotNull(message = "Quantity must be provided")
    private int quantity;

    @NotNull(message = "Operation must be specified")
    private productOperation operation;

}
