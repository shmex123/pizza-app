package Main;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Manager extends Person{
	
	int employeeID = 0;
	public int storeID = 0;
	public double wage = 10.00;
	public LinkedList<Employee> employees = new LinkedList<Employee>();

	public Manager(String name, String email, String phone) {
		super(name, email, phone);
	}
	
	public Manager(String name, String email, String phone, Address addr){
		super(name, email, phone, addr);
	}
	
	public Manager(String name, String email, String phone, String address1, String address2, String city, String locality, String postalCode, String country){
		super(name, email, phone, address1, address2, city, locality, postalCode, country);
	}
	
	/*
	 * This method creates a new employee and adds them to the list of active employees
	 * Not sure if this will be used
	 */
	public void Hire(Position p, Person newHire){
		Employee e = new Employee(p, newHire);
		employees.add(e);
	}
	
	public void Hire(String name, String email, String phone, String address1, String address2, String city, String locality, String postalCode, String country, Position p){
		Employee e = new Employee(name, email, phone, address1, address2, city, locality, postalCode, country, p);
		employees.add(e);
	}
	
	public void Hire(String name, String email, String phone, Address addr, Position p){
		Employee e = new Employee(name, email, phone, addr, p);
		employees.add(e);
	}
	/*
	 * This method removes an employee from the set
	 * Not sure if this will be used
	 */
	public void Fire(Person p){
		employees.remove(p);
	}

}
