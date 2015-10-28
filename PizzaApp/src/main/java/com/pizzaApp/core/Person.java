


package com.pizzaApp.core;


public class Person {

		private String name;
		private String email;
		private String phone;
		private Address addr = null;
		private PersonType type = PersonType.CUSTOMER;
		
		//Constructor w/ no address passed
		public Person (String name, String email, String phone){
			this.name = name;
			this.email = email;
			this.phone = phone;
		}
		
		//Constructor w/ address passed
		public Person (String name, String email, String phone, Address addr){
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.addr = addr;
		}
		
		//Constructor w/ address attributes passed
		public Person (String name, String email, String phone, String address1, String address2, String city, String locality, String postalCode, String country){
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.addr = new Address(address1, address2, city, locality, postalCode, country);
		}
		
		public boolean equals (Person p){
			if(this.name.equalsIgnoreCase(p.name) && this.email.equalsIgnoreCase(p.email)
					&& this.phone.equalsIgnoreCase(p.phone)){
				if(this.addr == null && p.addr == null){
					return true;
				}else if(this.addr.equals(p.addr)){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
		
		public String toString(){
			String str = "";
			if(this.addr != null){
				str = name + "\n" + email + "\n" + phone + "\n" + type + "\n" + addr.toString();
			}else{
				str = name + "\n" + email + "\n" + phone + type + "\n" +"\naddr = null";
			}
			return str;
		}
		
		/*
		 * This method creates a new order for the person and returns 
		 * the orderID
		 */
		public int placeOrder(){
			//TODO
			return 0;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
		
		public void setEmail(String email){
			this.email = email;
		}
		
		public String getEmail(){
			return email;
		}
		
		public void setPhone(String phone){
			this.phone = phone;
		}
		
		public String getPhone(){
			return phone;
		}
		
		public void setAddr(Address addr){
			this.addr = addr;
		}
		
		public Address getAddr(){
			return addr;
		}
		
		public void setType(PersonType type){
			this.type = type;
		}
		
		public PersonType getType(){
			return type;
		}

}
