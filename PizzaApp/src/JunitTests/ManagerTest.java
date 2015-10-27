package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.pizzaApp.core.Manager;
import com.pizzaApp.core.Person;
import com.pizzaApp.core.Position;

public class ManagerTest {

	@Test
	public void testHire() {
		Manager Mangie = new Manager("admin", "admin", "admin");
		Manager steve = new Manager("steve smeve", "stevethinksHesgreat@ymail.com", "1112223334", "2584 stevie dr", null, "Steville", "CO", "808080", "USA");
		
		Person[] p = PersonTest.generatePeople();
		
		Mangie.Hire(Position.CASHIER, p[0]);
		assertFalse(Mangie.employees.isEmpty());
		
		steve.Hire(Position.COOK, p[1]);
		assertFalse(steve.employees.isEmpty());
		
	}
	
	@Test
	public void testFire() {
		Manager Mangie = new Manager("admin", "admin", "admin");
		Manager steve = new Manager("steve smeve", "stevethinksHesgreat@ymail.com", "1112223334", "2584 stevie dr", null, "Steville", "CO", "808080", "USA");
		
		Person[] p = PersonTest.generatePeople();
		
		Mangie.Hire(Position.CASHIER, p[0]);
		steve.Hire(Position.COOK, p[1]);
		Mangie.Fire(p[0]);

	}

}
