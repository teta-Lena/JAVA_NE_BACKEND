package rw.lena.ne.java_ne.utils;

import org.modelmapper.ModelMapper;
import rw.lena.ne.java_ne.models.Customer;

public class Mapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static Customer getUserFromDTO(Object object) {
        return modelMapper.map(object, Customer.class);
    }


}
