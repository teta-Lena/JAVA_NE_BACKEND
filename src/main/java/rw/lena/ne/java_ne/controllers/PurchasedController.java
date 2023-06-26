package rw.lena.ne.java_ne.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.lena.ne.java_ne.dtos.PurchaseDTO;
import rw.lena.ne.java_ne.models.Purchased;
import rw.lena.ne.java_ne.payload.ApiResponse;
import rw.lena.ne.java_ne.services.PurchasedService;

import javax.validation.Valid;

public class PurchasedController {
    @RestController
    @RequestMapping("/api/v1/product-purchased")
    @CrossOrigin
    public class ProductPurchasedController {
        private final PurchasedService purchase;


        @Autowired
        public ProductPurchasedController(PurchasedService service) {
            this.purchase = service;
        }

        @GetMapping("/logged-in-user")

        public ResponseEntity<ApiResponse> getAllByLoggedInCustomer() {
            return ResponseEntity.ok(ApiResponse.success(purchase.byLoggedInCustomer()));
        }

        @GetMapping("/all")
        public ResponseEntity<ApiResponse> getAll() {
            return ResponseEntity.ok(ApiResponse.success(purchase.all()));
        }

        @PostMapping

        public ResponseEntity<ApiResponse> purchase(@Valid @RequestBody PurchaseDTO dto) {
            return ResponseEntity.ok(ApiResponse.success(this.purchase.purchase(dto)));
        }
    }

}
