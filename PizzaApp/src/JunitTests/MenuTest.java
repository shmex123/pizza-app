package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.pizzaApp.core.Menu;
import com.pizzaApp.core.MenuItem;


public class MenuTest {

	@Test
	public void testAddMenuItem() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem();
		MenuItem pepperoni = new MenuItem();
		MenuItem MeatLovers = new MenuItem();
		MenuItem veggie = new MenuItem();
		MenuItem sausage = new MenuItem();


		menu.addMenuItem(cheese);
		menu.addMenuItem(pepperoni);
		menu.addMenuItem(MeatLovers);
		menu.addMenuItem(veggie);
		menu.addMenuItem(sausage);

		assertEquals(5,menu.getItems().size());

	}
	@Test
	public void testAddMenuItem1() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);

		menu.addMenuItem(cheese);

		assertEquals(1,menu.getItems().size());

	}
	@Test
	public void testAddMenuItem2() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);
		MenuItem pepperoni = new MenuItem("Pepperoni Pizza", 10.99);
		MenuItem MeatLovers = new MenuItem("Meat Lovers Pizza", 12.99);
		MenuItem veggie = new MenuItem("veggie Pizza", 10.99);
		MenuItem sausage = new MenuItem("Sausage Pizza", 11.99);


		menu.addMenuItem(cheese);
		menu.addMenuItem(pepperoni);
		menu.addMenuItem(MeatLovers);
		menu.addMenuItem(veggie);
		menu.addMenuItem(sausage);
		menu.addMenuItem(sausage);
		

		assertEquals(5,menu.getItems().size());

	}
	@Test
	public void testRemoveMenuItem() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);
		menu.addMenuItem(cheese);
		assertEquals(1,menu.getItems().size());
		menu.removeMenuItem(cheese);
		assertEquals(0, menu.getItems().size());

	}
	@Test
	public void testRemoveMenuItem1() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);
		MenuItem pepperoni = new MenuItem("Pepperoni Pizza", 10.99);
		MenuItem MeatLovers = new MenuItem("Meat Lovers Pizza", 12.99);
		MenuItem veggie = new MenuItem("veggie Pizza", 10.99);
		MenuItem sausage = new MenuItem("Sausage Pizza", 11.99);


		menu.addMenuItem(cheese);
		menu.addMenuItem(pepperoni);
		menu.addMenuItem(MeatLovers);
		menu.addMenuItem(veggie);
		menu.addMenuItem(sausage);
		menu.removeMenuItem(pepperoni);
		

		assertEquals(4,menu.getItems().size());

	}
	public void testRemoveMenuItem2() {

		Menu menu = new Menu();

		MenuItem cheese = new MenuItem("cheese Pizza", 9.99);
		MenuItem pepperoni = new MenuItem("Pepperoni Pizza", 10.99);
		MenuItem MeatLovers = new MenuItem("Meat Lovers Pizza", 12.99);
		MenuItem veggie = new MenuItem("veggie Pizza", 10.99);
		MenuItem sausage = new MenuItem("Sausage Pizza", 11.99);


		menu.addMenuItem(cheese);
		menu.addMenuItem(pepperoni);
		menu.addMenuItem(MeatLovers);
		menu.addMenuItem(veggie);
		menu.addMenuItem(sausage);
		menu.removeMenuItem(pepperoni);
		menu.removeMenuItem(pepperoni);
		

		assertEquals(4,menu.getItems().size());

	}
	
	

}
