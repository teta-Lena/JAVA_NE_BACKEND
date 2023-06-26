package rw.lena.ne.java_ne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.lena.ne.java_ne.dtos.ProductDTO;
import rw.lena.ne.java_ne.models.Product;
import rw.lena.ne.java_ne.payload.ApiResponse;
import rw.lena.ne.java_ne.serviceImpls.ProductServiceImpl;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDTO dto) {
        Product newProduct = new Product();
        newProduct.setName(dto.getName());
        newProduct.setProductType(dto.getType());
        newProduct.setPrice(dto.getPrice());

        Product saveProduct = productService.addProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, saveProduct));

    }
}
