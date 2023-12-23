package com.example.Ecommerce.entity;

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
@Table(name = "item_master")
public class ItemMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "item_id")
	private String itemId;
	
	@Column(name = "item_value")
	private String itemValue;
	
	@Column(name = "order_id_fk")
	private Long orderIdFK;
	
	@Column(name = "item_quantity")
	private Long itemQuantity;
	
	@Column(name = "total_item_price")
	private String totalItemPrice;

		

}
