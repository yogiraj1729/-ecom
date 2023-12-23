package com.example.Ecommerce.entity;

import com.example.Ecommerce.Enum.OrderStatus;
import com.example.Ecommerce.Enum.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_master")
public class OrderMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "order_value")
	private String orderValue;
	
	@Column(name = "order_type")
	private String orderType;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "shipping_address")
	private String shippingAddress;
	
	@Column(name = "order_payment_status")
	private String paymentStatus;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	

}
