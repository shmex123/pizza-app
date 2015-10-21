/* 
 * Menu Item Model for API
 * This class is a java bean
 */

package com.pizzaApp.api.models;


public class MenuItem {
	
	private String id;
	private String name;
	private boolean inStock;
	private double price;
	private boolean isSpecial;

	public MenuItem(){}
	public MenuItem(String id, String name, boolean inStock,
		double price, boolean isSpecial) {
		
		this.id = id;
		this.name = name;
		this.inStock = inStock;
		this.price = price;
		this.isSpecial = isSpecial;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getIsSpecial() {
		return isSpecial;
	}
	public void setIsSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
}
