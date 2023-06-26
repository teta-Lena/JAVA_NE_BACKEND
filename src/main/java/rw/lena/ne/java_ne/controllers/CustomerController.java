package rw.lena.ne.java_ne.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rw.lena.ne.java_ne.dtos.SignUpDTO;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.payload.ApiResponse;
import rw.lena.ne.java_ne.services.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/users")
@CrossOrigin
public class CustomerController {

    private final CustomerService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public CustomerController(CustomerService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(path = "/current-user")
    public ResponseEntity<ApiResponse> currentlyLoggedInUser() {
        return ResponseEntity.ok(new ApiResponse(true, userService.getLoggedInCustomer()));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse> registerAsStandard(@Valid @RequestBody SignUpDTO dto) {

        Customer user = new Customer();

        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());

        user.setPhoneNumber(dto.getMobile());
        user.setPassword(encodedPassword);

        Customer entity = this.userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
    }

//    @PostMapping(path = "/register/as-admin")
//    public ResponseEntity<ApiResponse> registerAsAdmin(@Valid @RequestBody SignUpDTO dto) {
//
//        Customer user = new Customer();
//
//        String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());
//
//        user.setEmail(dto.getEmail());
//        user.setFirstName(dto.getFirstName());
//        user.setLastName(dto.getLastName());
//        user.setGender(dto.getGender());
//        user.setPhoneNumber(dto.getMobile());
//        user.setNationalId(dto.getNationalId());
//        user.setPassword(encodedPassword);
//        user.setRole(ERole.ADMIN);
//
//        Customer entity = this.userService.create(user);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, entity));
//    }

//    @GetMapping(path = "/routes/admin")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    public ResponseEntity<ApiResponse> adminRoute(){
//        return ResponseEntity.ok(ApiResponse.success("Admin route"));
//    }
//
//    @GetMapping(path = "/routes/standard")
//    @PreAuthorize("hasAnyAuthority('STANDARD')")
//    public ResponseEntity<ApiResponse> standardRoute(){
//        return ResponseEntity.ok(ApiResponse.success("Standard route"));
//    }
}