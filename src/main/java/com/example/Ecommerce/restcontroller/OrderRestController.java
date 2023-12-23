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

import com.example.Ecommerce.Enum.OrderType;
import com.example.Ecommerce.dto.RequestDTO;
import com.example.Ecommerce.service.OrderService;
import com.example.Ecommerce.util.Constants;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/addItemToCart")
	public ResponseEntity<Map<String, Object>> addItemToCart(@RequestBody RequestDTO requestDTO) throws Exception {
		
		Map<String, Object> orderDetails = orderService.addItemIntoCart(requestDTO.getItemId(),OrderType.ADD_TO_CART.getValue(),requestDTO.getQuantity());
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}
	
	@GetMapping("/getItemsCount")
	public ResponseEntity<Map<String, Object>> getItemsCount() throws Exception {
		
		Map<String, Object> orderDetails = orderService.getItemsCount(Constants.USER_ID);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}
}
