package rw.lena.ne.java_ne.serviceImpls;

import org.springframework.stereotype.Service;
import rw.lena.ne.java_ne.dtos.PurchaseDTO;
import rw.lena.ne.java_ne.dtos.QuantityDTO;
import rw.lena.ne.java_ne.enums.productOperation;
import rw.lena.ne.java_ne.models.Customer;
import rw.lena.ne.java_ne.models.Purchased;
import rw.lena.ne.java_ne.models.Quantity;
import rw.lena.ne.java_ne.repositories.PurchasedRepository;
import rw.lena.ne.java_ne.services.CustomerService;
import rw.lena.ne.java_ne.services.PurchasedService;
import rw.lena.ne.java_ne.services.QuantityService;

import java.util.List;

@Service
public class PurchasedServiceImpl implements PurchasedService {

    private final PurchasedRepository  purchasedRepository;

    private final CustomerService service;

    private final QuantityService productQuantityService;

    public PurchasedServiceImpl(PurchasedRepository repository, CustomerService service, QuantityService productQuantityService) {
        this.purchasedRepository = repository;
        this.service = service;
        this.productQuantityService = productQuantityService;
    }

    @Override
    public List<Purchased> byLoggedInCustomer() {
        Customer customer = service.getLoggedInCustomer();
        return purchasedRepository.findByCustomer(customer);
    }

    @Override
    public List<Purchased> all() {
        return purchasedRepository.findAll();
    }

    @Override
    public Purchased purchase(PurchaseDTO dto) {
        Customer customer = service.getLoggedInCustomer();

//        QuantityDTO newProductQuantityDTO = new QuantityDTO(dto.getCode(),dto.getQuantity(), productOperation.PRODUCT_OUT);
        Quantity newQty = new Quantity(dto.getCode(),dto.getQuantity(),productOperation.PRODUCT_OUT);
        Quantity newQuantity = productQuantityService.addQuantity(newQty);


        Purchased productPurchased = new Purchased(newQuantity,customer);

        return purchasedRepository.save(productPurchased);
    }
}
