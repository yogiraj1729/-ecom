package com.example.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Ecommerce.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ecom")
public class TestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getPage")
	public String getPage() throws Exception {
		// System.out.println("application running");		
	    log.error("my data :: {}",productService.getProductDetails());
		return "test";
	}

}
