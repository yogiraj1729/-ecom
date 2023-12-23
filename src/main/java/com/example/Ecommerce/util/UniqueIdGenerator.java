package com.example.Ecommerce.util;

import java.util.Random;

public class UniqueIdGenerator {
	private UniqueIdGenerator() {

	}
	
	public static String getProductId() {		
		return "prd_"+getRandomNumberString();
	}
	
	public static String getOrderId() {		
		return "order_"+getRandomNumberString();
	}
	
	public static String getItemId() {		
		return "item_"+getRandomNumberString();
	}
	
	public static String getTransactionId() {		
		return "trans_"+getRandomNumberString();
	}
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
}
