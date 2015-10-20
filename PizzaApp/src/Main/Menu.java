package Main;

import java.util.HashSet;
import java.util.Set;

public class Menu {

	static Set<MenuItem> items = new HashSet<MenuItem>();
	
	public static void addMenuItem(MenuItem item){
		items.add(item);		
	}
	
	public void removeMenuItem(MenuItem item){		
		items.remove(item);		
	}
	public Set<MenuItem> getItems(){
		return items;
	}
	
	public static void main(String[] args){
				
		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);
		MenuItem pepperoni = new MenuItem("Pepperoni Pizza", 10.99);
		MenuItem MeatLovers = new MenuItem("Meat Lovers Pizza", 12.99);
		MenuItem veggie = new MenuItem("veggie Pizza", 10.99);
		MenuItem sausage = new MenuItem("Sausage Pizza", 11.99);
		
		addMenuItem(cheese);
		addMenuItem(pepperoni);
		addMenuItem(MeatLovers);
		addMenuItem(veggie);
		addMenuItem(sausage);
		
		
		
		System.out.println(items.size());
		
		
	}
	
}
