package com.pizzaApp.core;

public class PaymentTransaction {
	private String timestamp;
	private double amount;
	private String paymentType;
	
			
	public PaymentTransaction(){
		timestamp = "" + System.currentTimeMillis() / 1000L;
	}
	
	public PaymentTransaction(String timestamp, double amount, String paymentType){
		this.timestamp =  timestamp;
		this.amount = amount;
		this.paymentType = paymentType;
	}
	
	public String getTimestamp(){
		return timestamp;
	}
	
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public String getPaymentType(){
		return paymentType;
	}
	
	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;
	}
}
