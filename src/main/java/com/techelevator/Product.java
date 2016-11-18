package com.techelevator;

public class Product {
	private double price;
	private String name;
	private String slotID;
	private int quantity;
	
	public Product(String slotID, String name, double price, int quantity) {
		this.price = price;
		this.name = name;
		this.slotID = slotID;
		this.quantity = quantity;
	}
	
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSlotID() {
		return slotID;
	}


}
