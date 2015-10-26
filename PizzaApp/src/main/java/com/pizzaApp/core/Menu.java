

package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {

	private static final Menu instance = new Menu();
	private Map<String, MenuItem> items = new HashMap<String, MenuItem>();
	
	private Menu(){}

	public static Menu sharedInstance() {
		return instance;
	}
	
	public void addMenuItem(MenuItem item){
		synchronized(items) {
			items.put(item.getId(), item);		
		}
	}
	
	public void removeMenuItem(MenuItem item){		
		synchronized(items) {
			items.remove(item.getId());		
		}
	}

	public MenuItem removeById(String id) {
		synchronized(id) {
			return items.remove(id);
		}
	}

	public List<MenuItem> list(){
		synchronized(items) {
			return new ArrayList<MenuItem>(items.values());
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
}
