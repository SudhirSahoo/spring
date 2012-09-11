package com.skumar.spring.mvc.service.impl;

import java.util.List;

import com.skumar.spring.mvc.domain.Product;
import com.skumar.spring.mvc.service.ProductManager;

public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}