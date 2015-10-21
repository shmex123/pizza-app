
package com.pizzaApp.core;

public class MenuItem {

	private String name;
	private boolean inStock = true;
	private double price;
	private boolean isSpecial = false;
	private String size;
	
	public MenuItem(String n, double p){
		name = n;
		price = p;
	}
	
	
}
