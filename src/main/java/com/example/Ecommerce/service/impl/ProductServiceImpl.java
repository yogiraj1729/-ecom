package com.example.Ecommerce.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.dto.ItemDTO;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.entity.Seller;
import com.example.Ecommerce.repository.ProductRepository;
import com.example.Ecommerce.repository.SellerRepository;
import com.example.Ecommerce.service.ProductService;
import com.example.Ecommerce.util.Constants;
import com.example.Ecommerce.util.UniqueIdGenerator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public Map<String, Object> getProductDetails() throws Exception {

		Map<String, Object> result = new HashMap<>();
		List<Product> productDetails = productRepository.findAll();
		result.put("data", productDetails);
		return result;
	}

	@Override
	public Map<String, Object> saveProductDetails(ItemDTO itemDTO) throws Exception {
		
		Map<String,Object> result=new HashMap<>();
		
		Seller opSeller=sellerRepository.findBySellerName(Constants.SELLER_NAME).orElseThrow(()->new Exception("Seller is Not"));
		
		Product product=Product.builder()
				.itemName(itemDTO.getItemName())
				.itemPrice(Double.parseDouble(itemDTO.getItemPrice()))
				.sellerId(opSeller.getId())
				.itemId(UniqueIdGenerator.getProductId())
				.build();
		
		productRepository.save(product);
		
		result.put("data",product);
		return result;
	
	}

}
