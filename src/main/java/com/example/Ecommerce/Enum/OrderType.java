package com.example.Ecommerce.Enum;

public enum OrderType {
	BUY("Buy"), ADD_TO_CART("Add-To-Cart");

	String value;

	OrderType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
