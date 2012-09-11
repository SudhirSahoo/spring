package com.skumar.spring.mvc.service;

import java.io.Serializable;
import java.util.List;

import com.skumar.spring.mvc.domain.Product;

public interface ProductManager extends Serializable{

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
    
}
