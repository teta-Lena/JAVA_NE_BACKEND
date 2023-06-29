//package rw.lena.ne.java_ne.serviceImpls;
//
//import org.springframework.stereotype.Service;
//import rw.lena.ne.java_ne.dtos.PurchaseDTO;
//import rw.lena.ne.java_ne.dtos.QuantityDTO;
//import rw.lena.ne.java_ne.enums.productOperation;
//import rw.lena.ne.java_ne.models.Customer;
//import rw.lena.ne.java_ne.models.Purchased;
//import rw.lena.ne.java_ne.models.Quantity;
//import rw.lena.ne.java_ne.repositories.PurchasedRepository;
//import rw.lena.ne.java_ne.services.CustomerService;
//import rw.lena.ne.java_ne.services.PurchasedService;
//import rw.lena.ne.java_ne.services.QuantityService;
//
//import java.util.List;
//
//@Service
//public class PurchasedServiceImpl implements PurchasedService {
//
//    private  PurchasedRepository  purchasedRepository;
//
//    private  CustomerService service;
//
//    private  QuantityService qtyService;
//
//    public PurchasedServiceImpl(PurchasedRepository repository, CustomerService service, QuantityService productQuantityService) {
//        this.purchasedRepository = repository;
//        this.service = service;
//        this.qtyService = productQuantityService;
//    }
//
//    @Override
//    public List<Purchased> byAuthenticatedCustomer() {
//        Customer customer = service.getLoggedInCustomer();
//        return purchasedRepository.findPurchasedByCustomer(customer);
//    }
//
//    @Override
//    public List<Purchased> getAllPurchasedProducts() {
//        return purchasedRepository.findAll();
//    }
//
//    @Override
//    public Purchased purchase(PurchaseDTO dto) {
//        Customer customer = service.getLoggedInCustomer();
//
////        QuantityDTO newProductQuantityDTO = new QuantityDTO(dto.getCode(),dto.getQuantity(), productOperation.PRODUCT_OUT);
//        QuantityDTO newQty = new QuantityDTO(dto.getCode(),dto.getQuantity(),productOperation.PRODUCT_OUT);
//
//        Quantity saveQuantity = qtyService.newQuantityByRequest(newQty);
//
//
//        Purchased productPurchased = new Purchased(saveQuantity,customer);
//
//        return purchasedRepository.save(productPurchased);
//    }
//}
