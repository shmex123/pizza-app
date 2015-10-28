package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;
import com.pizzaApp.core.Person;


public class PersonTest {

	@Test
	public void testAddMenuItem() {

		Person Jon = new Person("Jon", "hello@gmail.com", "303030303", "Denver");
		Person Jim = new Person("Jim", "hi@gmail.com", "1234123123", "Cheyanne");

		assertEquals(false,Jon.equals(Jim));
		assertEquals(true,Jon.equals(Jon));

	}
