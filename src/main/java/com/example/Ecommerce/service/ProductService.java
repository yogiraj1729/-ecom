package com.example.Ecommerce.service;

import java.util.Map;

import com.example.Ecommerce.dto.ItemDTO;

public interface ProductService {

	public Map<String,Object> getProductDetails() throws Exception;
	
	public Map<String,Object> saveProductDetails(ItemDTO itemDTO) throws Exception;
}
