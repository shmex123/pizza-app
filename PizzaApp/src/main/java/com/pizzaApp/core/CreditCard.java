package com.pizzaApp.core;

public class CreditCard{
  
  private String CVS;
  private String Number;
  private String Name;
  private String Experation;
  
  public CreditCard(){}
  
  public String getCVS(){
		return CVS;
	}
	
	public void setCVS(String CVS){
		this.CVS = CVS;
	}
	
	public String getNumber(){
		return Number;
	}
	
	public void setNumber(String Number){
		this.Number = Number;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getExperation(){
		return Experation;
	}
	
	public void setExperation(String Experation){
		this.Experation = Experation;
	}
	
}
