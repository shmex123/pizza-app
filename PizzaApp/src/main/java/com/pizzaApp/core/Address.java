
package com.pizzaApp.core;

public class Address {
	
	String address1;
	String address2;
	String city;
	String locality;
	String postalCode;
	String country;
	
	
	public Address (String address1, String address2, String city, String locality, String postalCode, String country){
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.locality = locality;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public boolean equals (Address x){
		if(this.address1.equalsIgnoreCase(x.address1) && this.address2.equalsIgnoreCase(x.address2)
				&& this.city.equalsIgnoreCase(x.city) && this.locality.equalsIgnoreCase(x.locality)
				&& this.postalCode.equalsIgnoreCase(x.postalCode) && this.country.equalsIgnoreCase(x.country)){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		String str = address1 + "\n";
		if(address2 == null || address2.equals("")){
			str += address2 + "\n";
		}
		str += city + ", " + locality + ", " + postalCode + "\n";
		return str;
		
	}

}
