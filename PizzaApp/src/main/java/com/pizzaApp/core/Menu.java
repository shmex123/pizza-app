

package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

	private static final Menu instance = new Menu();
	private Map<String, MenuItem> items = new HashMap<String, MenuItem>();
	
	private Menu(){
		createSeedData();
	}

	public static Menu sharedInstance() {
		return instance;
	}
	
	public void addMenuItem(MenuItem item){
		synchronized(items) {
			items.put(item.getId(), item);		
		}
	}
	
	//NOTE: We cannot actually delete anything or we run into null pointer problems
		//We change the status to delete instead
	public void removeMenuItem(MenuItem item){		
		synchronized(items) {
			items.get(item.getId()).setStatus(MenuItemStatus.DELETED);
		}
	}

	//NOTE: We cannot actually delete anything or we run into null pointer problems
		//We change the status to delete instead
	public MenuItem removeById(String id) {
		synchronized(id) {
			items.get(id).setStatus(MenuItemStatus.DELETED);
			return items.get(id);
		}
	}
	
	//Returns a list of orders whose status is not DELETED
	public List<MenuItem> list(){
		synchronized(items) {
			List<MenuItem> orders = new ArrayList<MenuItem>();
			
			for(MenuItem item: items.values()){
				if(item.getStatus() != MenuItemStatus.DELETED){
					orders.add(item);
				}
			}
			return orders;
		}
	}

	public MenuItem get(String id) {
		synchronized(items) {
			return items.get(id);
		}
	}

	public void replace(String id, MenuItem item) {
		synchronized(items) {
			items.put(id, item);
		}
	}
	
	//Populate the menu with default items. When the application starts there is things that can be ordered
	public void createSeedData(){
		MenuItem pepperoniPizzaDeal = new MenuItem("Pepperoni Pizza Deal", true, 9.99, false, "Medium");
		MenuItem sausagePizzaDeal = new MenuItem("Sausage Pizza Deal", true, 10.99, false, "Meduim");
		MenuItem cheesePizzaDeal = new MenuItem("Cheese Pizza Deal", true, 8.99, false, "Meduim");
		MenuItem hotWings = new MenuItem("Hot Wings", true, 4.99, false, null);
		MenuItem cocoCookies = new MenuItem("5 Chocolate Chip Cookies", true, 4.99, false, null);
		MenuItem soda = new MenuItem("Soda", true, 2.99, false, "2 Liters");
		
		items.put(pepperoniPizzaDeal.getId(), pepperoniPizzaDeal);
		items.put(sausagePizzaDeal.getId(), sausagePizzaDeal);
		items.put(cheesePizzaDeal.getId(), cheesePizzaDeal);
		items.put(hotWings.getId(), hotWings);
		items.put(cocoCookies.getId(), cocoCookies);
		items.put(soda.getId(), soda);
		
	}
}
