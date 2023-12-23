package com.example.Ecommerce.Enum;

public enum PaymentStatus {
	SUCCESS("Success"), FAILED("Failed"), PENDING("Pending");

	String value;

	PaymentStatus(String value) {
		this.value = value;
	}
	
	String getValue() {
		return this.value;
	}

}
