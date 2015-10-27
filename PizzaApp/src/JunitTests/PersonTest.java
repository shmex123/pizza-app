package JunitTests;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import org.junit.Test;
import com.pizzaApp.core.Person;
import com.pizzaApp.core.Address;

public class PersonTest {

	@Test
	public void testEquals() {
		Person[] people = generatePeople();
		
		assertTrue(people[0].equals(people[2]));
		assertFalse(people[0].equals(people[1]));
		
		System.out.println(people[0].toString());
	}
	
	@Test
	public void testPlaceOrder(){
		
		Person jon = new Person("jon nobody", "jonisAnobody@gmail.com", "3033331517");
		assertTrue(jon.placeOrder() >= 0);
	}
	
	//generates an array of people to be used in a test class
	public static Person[] generatePeople(){
				
		Address sameAsSteve = new Address("2584 stevie dr", null, "Steville", "CO", "808080", "USA");
		
		Person jon = new Person("jon nobody", "jonisAnobody@gmail.com", "3033331517");
		Person steve = new Person("steve smeve", "stevethinksHesgreat@ymail.com", "1112223334", "2584 stevie dr", null, "Steville", "CO", "808080", "USA");
		Person jonAgain = new Person("jon nobody", "jonisAnobody@gmail.com", "3033331517");
		Person connie = new Person("connie smeve", "connieIsSmevesWife@match.com", "1112223334", sameAsSteve);
		
		Person[] people = {jon, steve, jonAgain, connie};
		return people;
	}

}
