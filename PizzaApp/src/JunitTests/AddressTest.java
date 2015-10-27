package JunitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pizzaApp.core.Address;

public class AddressTest {

	@Test
	public void testEquals() {
		Address addr = new Address("2222 Rainway Street", "APT 475", "Coliins, Ft", "Colorado", "89789", "USA");
		Address addr1Again = new Address("2222 Rainway Street", "APT 475", "Coliins, Ft", "Colorado", "89789", "USA");
		Address addr2 = new Address("1747 Ensenada Street", null, "Rainbeach", "Florida", "15789", "USA");
		
		assertTrue(addr.equals(addr1Again));
		assertFalse(addr1Again.equals(addr2));
		System.out.println(addr.toString());
	}
	

}
