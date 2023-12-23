package com.example.Ecommerce.service;

import java.util.Map;

public interface OrderService {

	Map<String,Object> addItemIntoCart(String itemId,String orderType,Long quantity) throws Exception;

	Map<String, Object> getItemsCount(String userId);
}
