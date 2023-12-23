package com.example.Ecommerce.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.Enum.OrderStatus;
import com.example.Ecommerce.Enum.OrderType;
import com.example.Ecommerce.entity.ItemMaster;
import com.example.Ecommerce.entity.OrderMaster;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.entity.UserMaster;
import com.example.Ecommerce.repository.ItemRepository;
import com.example.Ecommerce.repository.OrderRepository;
import com.example.Ecommerce.repository.ProductRepository;
import com.example.Ecommerce.repository.UserRepository;
import com.example.Ecommerce.service.OrderService;
import com.example.Ecommerce.util.Constants;
import com.example.Ecommerce.util.UniqueIdGenerator;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Map<String, Object> addItemIntoCart(String itemId,String orderType,Long quantity) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> response= new HashMap<>();
		 
		if(itemId==null) {
			throw new Exception("ItemId is Invalid");
		}
		
		Optional<Product> opItemId = productRepository.findByItemId(itemId);
		if(!opItemId.isPresent()) {
			throw new Exception("No Item Available for the given ItemId");
		}
		
		Product product=opItemId.get();
		
		OrderMaster order= createOrder(Constants.USER_ID,orderType);
		
		createItem(product,order,quantity);
		
		order=doFinalCalculation(order);
		
		response.put("order", order);
		
		return response;
	}

	private OrderMaster doFinalCalculation(OrderMaster order) {
		// TODO Auto-generated method stub
		
		List<ItemMaster> itemList = itemRepository.findByOrderIdFK(order.getId());
	    
		Double totalOrderPrice=0.00;
		
		for(ItemMaster item: itemList) {
			totalOrderPrice=totalOrderPrice+Double.parseDouble(item.getTotalItemPrice());
		}
		
		order.setOrderValue(String.valueOf(totalOrderPrice));
		return orderRepository.saveAndFlush(order);		
	}

	private ItemMaster createItem(Product product,OrderMaster order,Long quantity) {
		
		Optional<ItemMaster> byorderIdFKAndItemId = itemRepository.findByOrderIdFKAndItemId(order.getId(),product.getItemId());		
		quantity=quantity==null ? 1 : quantity;
		
		ItemMaster item=ItemMaster.builder()
				.itemId(product.getItemId())
				.itemValue(String.valueOf(product.getItemPrice()))
				.itemQuantity(quantity)
				.totalItemPrice(String.valueOf(product.getItemPrice()*quantity))
				.orderIdFK(order.getId())
				.build();
		
		if(byorderIdFKAndItemId.isPresent()) {
			item.setId(byorderIdFKAndItemId.get().getId());
		}
		
		return itemRepository.saveAndFlush(item);
	}

	private OrderMaster createOrder(String userName, String orderType) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<UserMaster> byUserName = userRepository.findByUserName(userName);
		if(!byUserName.isPresent()) {
			throw new Exception("User Not found");
		}
		
		UserMaster userMaster=byUserName.get();
		
		Optional<OrderMaster> byUserIdAndOrderTypeAndOrderStatus = orderRepository.findByUserIdAndOrderTypeAndOrderStatus(userMaster.getId(), orderType, OrderStatus.OPEN.getValue());
	
		OrderMaster order=OrderMaster.builder()
				.orderId(UniqueIdGenerator.getOrderId())
				.orderType(orderType)
				.userId(userMaster.getId())
				.orderStatus(OrderStatus.OPEN.getValue())
				.build();
		
		if(byUserIdAndOrderTypeAndOrderStatus.isPresent()) {
			order.setId(byUserIdAndOrderTypeAndOrderStatus.get().getId());
		}
		return orderRepository.saveAndFlush(order);
		
	}

	@Override
	public Map<String, Object> getItemsCount(String userId) {
		// TODO Auto-generated method stub
		
		Optional<UserMaster> byUserName = userRepository.findByUserName(userId);
		UserMaster userMaster = byUserName.get();
	Long id = userMaster.getId();
	Optional<OrderMaster> byUserIdAndOrderStatusAndOrderType = orderRepository.findByUserIdAndOrderTypeAndOrderStatus(id, OrderType
			.ADD_TO_CART.getValue(),OrderStatus.OPEN.getValue());
	Long id2 = byUserIdAndOrderStatusAndOrderType.get().getId();
	List<ItemMaster> byOrderIdFK = itemRepository.findByOrderIdFK(id2);
	long count = byOrderIdFK.stream().count();
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("cartCount", count);
	return map;
	}

}
