package rw.lena.ne.java_ne.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.lena.ne.java_ne.exceptions.BadRequestException;
import rw.lena.ne.java_ne.models.Product;
import rw.lena.ne.java_ne.repositories.CustomerRepository;
import rw.lena.ne.java_ne.repositories.ProductRepository;
import rw.lena.ne.java_ne.services.ProductService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//    @Override
//    public String addProduct(String name, String type, int price, Date date){
//
//    }

    @Override
    public Product addProduct(Product product){
        validateProduct(product);

        return productRepository.save(product);

    }

    public void validateProduct(Product product){
        if(isExists(product)){
            throw new BadRequestException(String.format("Such a product already exists"));
        }
    }

    @Override
    public Product getProductByCode(Long code) {
        Optional<Product> productOptional = productRepository.findByCode(code);
        return productOptional.orElse(null);
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

//    @Override
//    public List<Product> getAllProductsByType(String type){
//
//    }

//    List<Product> searchAllProducts(String search);

    @Override
     public boolean isExists(Product product){
        Optional<Product> foundProduct = productRepository.findProductByNameAndProductTypeAndPrice(product.getName(),product.getProductType(), product.getPrice());
        return foundProduct.isPresent();
     }


//    Product getProductDetails(UUID code);


}
