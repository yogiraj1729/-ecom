package com.example.Ecommerce.Enum;

public enum OrderStatus {
	OPEN("Open"), CLOSE("Close");

	String value;

	OrderStatus(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
