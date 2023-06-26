package rw.lena.ne.java_ne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.lena.ne.java_ne.dtos.ProductDTO;
import rw.lena.ne.java_ne.dtos.QuantityDTO;
import rw.lena.ne.java_ne.models.Product;
import rw.lena.ne.java_ne.models.Quantity;
import rw.lena.ne.java_ne.payload.ApiResponse;
import rw.lena.ne.java_ne.serviceImpls.ProductServiceImpl;
import rw.lena.ne.java_ne.serviceImpls.QuantityServiceImpl;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/quantities")
public class QuantityController {
    private QuantityServiceImpl quantityService;
    private ProductServiceImpl productService;

    @Autowired
    public QuantityController(QuantityServiceImpl qtyService,ProductServiceImpl productService){
        this.quantityService = qtyService;
        this.productService= productService;
    }

    @PostMapping("/addQuantity")
    public ResponseEntity<ApiResponse> addQuantity(@Valid @RequestBody QuantityDTO dto) {
          Product product = productService.getProductByCode(dto.getProductCode());
        if (product == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid product code."));
        }

        Quantity newQty = new Quantity();
        newQty.setProduct(product);
        newQty.setQuantity(dto.getQuantity());
        newQty.setOperation(dto.getOperation());

        Quantity saveQuantity =  quantityService.addQuantity(newQty);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, saveQuantity));

    }
    @PutMapping("/updateQuantity/{code}")
    public ResponseEntity<ApiResponse> updateQuantity(@PathVariable Long code, @Valid @RequestBody QuantityDTO dto) {
        Product product = productService.getProductByCode(code);
        if (product == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not found."));
        }

        Quantity quantity = quantityService.findByProductCode(code);
        if (quantity == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Quantity not found."));
        }

        quantity.setQuantity(dto.getQuantity());
        quantity.setOperation(dto.getOperation());

        Quantity updatedQuantity = quantityService.updateQuantity(quantity);
        if (updatedQuantity == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Failed to update quantity."));
        }

        return ResponseEntity.ok(new ApiResponse(true, "Quantity updated successfully."));
    }


}
