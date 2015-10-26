


package com.pizzaApp.core;

public class Employee extends Person{

	int storeID = 0;
	Position p;
	double wage = 8.50;
	
	public Employee(Position p, Person newHire) {
		super(newHire.name, newHire.email, newHire.phone);
		this.p = p;
	}
	
	public Employee(String name, String email, String phone, Address addr, Position p){
		super(name, email, phone, addr);
		this.p = p;
	}
	
	public Employee(String name, String email, String phone, String address1, String address2, String city, String locality, String postalCode, String country, Position p){
		super(name, email, phone, address1, address2, city, locality, postalCode, country);
		this.p = p;
	}
	
	public String toString(){
		String str = super.toString();
		str += "\n" + "StoreID: " + storeID + "\n" + "Position: " + p + "Wage: " + wage;
		return str;
	}
	
	public boolean equals(Employee e){
		Person tP = (Person) this;
		if(tP.equals((Person)e) /*&& this.storeID == e.storeID
				&& this.p == e.p && this.wage == e.wage*/){
			return true;
		}else{
			return false;
		}
	}
}
