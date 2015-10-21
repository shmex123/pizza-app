package Main;

public class Person {

		String name;
		String email;
		String phone;
		Address addr = null;
		
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
				str = name + "\n" + email + "\n" + phone + "\n" + addr.toString();
			}else{
				str = name + "\n" + email + "\n" + phone + "\naddr = null";
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
}
