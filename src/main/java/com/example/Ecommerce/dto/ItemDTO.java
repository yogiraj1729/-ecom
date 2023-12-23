package com.example.Ecommerce.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Builder
@Setter
@ToString
public class ItemDTO {
	private String itemName;
	private String itemPrice;
	private String itemImage;
	private String itemCategory;
	private String itemSellerName;
	
	private String itemId;
}
