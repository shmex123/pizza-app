package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import JunitTests.PersonTest;
import Main.Address;
import Main.Employee;
import Main.Person;
import Main.Position;

public class EmployeeTest {

	@Test
	public void testEquals() {
		Employee[] e = generateEmployees();
		
		assertTrue(e[0].equals(e[2]));
		assertFalse(e[1].equals(e[3]));
	}
	@Test
	public void testPlaceOrder(){
		Employee[] e = generateEmployees();
		
		assertTrue(e[3].placeOrder() == 0);
	}
	
	public static Employee[] generateEmployees(){
		Person[] p = PersonTest.generatePeople();
		Address sameAsSteve = new Address("2584 stevie dr", null, "Steville", "CO", "808080", "USA");
		
		Employee jon = new Employee(Position.CASHIER, p[0]);
		Employee steve = new Employee("steve smeve", "stevethinksHesgreat@ymail.com", "1112223334", "2584 stevie dr", null, "Steville", "CO", "808080", "USA", Position.COOK);
		Employee jonAgain = new Employee(Position.CASHIER, p[2]);
		Employee connie = new Employee("connie smeve", "connieIsSmevesWife@match.com", "1112223334", sameAsSteve, Position.DRIVER);
	
		Employee[] e = {jon, steve, jonAgain, connie};
		return e;
	}


}
