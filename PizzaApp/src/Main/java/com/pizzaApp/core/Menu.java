

package com.pizzaApp.core;

import java.util.HashSet;
import java.util.Set;

public class Menu {

	Set<MenuItem> items = new HashSet<MenuItem>();
	
	public Menu(){
		
	}
	public Menu(Set<MenuItem> i){
		
		items=i;
		
	}
	
	public void addMenuItem(MenuItem item){
		items.add(item);		
	}
	
	public void removeMenuItem(MenuItem item){		
		items.remove(item);		
	}
	public Set<MenuItem> getItems(){
		return items;
	}
	
}
