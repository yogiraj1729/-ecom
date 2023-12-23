package com.example.Ecommerce.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.dto.ItemDTO;
import com.example.Ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProduct")
	public ResponseEntity<Map<String, Object>> getAllProducts() throws Exception {		
		Map<String, Object> productDetails = productService.getProductDetails();
		return new ResponseEntity<>(productDetails, HttpStatus.OK);
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Map<String, Object>> saveProductDetails(@RequestBody ItemDTO itemDTO) throws Exception {
		
		Map<String, Object> productDetails = productService.saveProductDetails(itemDTO);
		return new ResponseEntity<>(productDetails, HttpStatus.OK);
	}

}
