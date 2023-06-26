package rw.lena.ne.java_ne.services;

import rw.lena.ne.java_ne.models.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ProductService {
//     String addProduct(String name, String type, int price, Date date);

     Product addProduct(Product product);

//    public String removeProduct(String prodId);

//    public String updateProduct(Product prevProduct, Product updatedProduct);

//    public String updateProductPrice(UUID code, int price);

     List<Product> getAllProducts();

//     List<Product> getAllProductsByType(String type);

//     List<Product> searchAllProducts(String search);

     boolean isExists(Product product);

     Product getProductByCode(Long code);

//     Product getProductDetails(UUID code);
}
