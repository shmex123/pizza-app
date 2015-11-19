package com.pizzaApp.core;

public class CreditCard{
  
  private String cvs;
  private String number;
  private String name;
  private String expiration;
  
  public CreditCard(){}
  
  	public String getCvs(){
		return cvs;
	}
	
	public void setCvs(String cvs){
		this.cvs = cvs;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getExpiration(){
		return expiration;
	}
	
	public void setExpiration(String expiration){
		this.expiration = expiration;
	}
	
}
