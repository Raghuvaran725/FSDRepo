package com.order.main.exception;

public class OrderNotFoundException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6161104222882221638L;
	public OrderNotFoundException(int oid) {
		super(String.format("Order with Id %d not found", oid));
	}
}
