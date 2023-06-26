package rw.lena.ne.java_ne.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.lena.ne.java_ne.dtos.QuantityDTO;
import rw.lena.ne.java_ne.exceptions.BadRequestException;
import rw.lena.ne.java_ne.models.Quantity;
import rw.lena.ne.java_ne.repositories.QuantityRepository;
import rw.lena.ne.java_ne.services.QuantityService;

import java.util.List;
import java.util.Optional;

@Service
public class QuantityServiceImpl implements QuantityService {

    private QuantityRepository qtyRepository;

    @Autowired
    public QuantityServiceImpl(QuantityRepository quantityRepository){
        this.qtyRepository = quantityRepository;
    }

    @Override
    public Quantity addQuantity(Quantity qty){
        ValidateQuantity(qty);
        return qtyRepository.save(qty);
    }
    @Override
    public List<Quantity> getAllQuantities(){
        return qtyRepository.findAll();
    }
    public void ValidateQuantity(Quantity qty){
         Optional <Quantity> quantity =  qtyRepository.findByQuantityAndProductCode(qty.getQuantity(),qty.getProductCode());
        if(quantity.isPresent()){
            throw new BadRequestException(String.format("Already assigned a quantity to that product you can only update!"));
        }
    }
    @Override
    public boolean isExistsByQuantity(Quantity quantity){
        Optional<Quantity> foundProduct = qtyRepository.findByProductCode(quantity.getProduct().getCode());
        return foundProduct.isPresent();
    }
    @Override
    public Quantity updateQuantity(Quantity qty){
        Optional<Quantity> foundProduct = qtyRepository.findByProductCode(qty.getProduct().getCode());
        if(foundProduct.isPresent()){
            Quantity existingQuantity = foundProduct.get();
            existingQuantity.setQuantity(qty.getQuantity());
            return qtyRepository.save(existingQuantity);
        }
        return null;
    }
    @Override
    public Quantity findByProductCode(Long productCode) {
        Optional<Quantity> quantity = qtyRepository.findByProductCode(productCode);
        return quantity.orElse(null);
    }

}
