package com.pizzaApp.core;

import java.util.UUID;

public class PaymentTransaction {
	
	private String id;
	private String timestamp;
	private double amount;
	private String paymentType;
	private CreditCard CardInformation;
	
			
	public PaymentTransaction(){
		this.id = UUID.randomUUID().toString();
		this.timestamp = "" + System.currentTimeMillis() / 1000L;
	}
	
	public PaymentTransaction(String timestamp, double amount, String paymentType){
		this.id = UUID.randomUUID().toString();
		this.timestamp =  timestamp;
		this.amount = amount;
		this.paymentType = paymentType;
	}
	
	public CreditCard getCardInformation(){
		return CardInformation;
	}
	
	public void setCardInformation(CreditCard CardInformation){
		this.CardInformaion = cardInformation;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
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
