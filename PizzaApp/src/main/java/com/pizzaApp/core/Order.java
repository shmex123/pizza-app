
package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

public class Order {

	private String id;
	private String timestamp;
	private OrderStatus status;
	private Set<LineItem> lineItems;
	private List<PaymentTransaction> transactions;
	private boolean isDelivery;
	private Person person;
	private Address address;
	private String phoneNumber = "";
	

	public Order() {
		this.id = UUID.randomUUID().toString();
		timestamp = "" + System.currentTimeMillis() / 1000L;
		status = OrderStatus.OPEN;
		lineItems = new HashSet<LineItem>();
		transactions = new ArrayList<PaymentTransaction>();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems){
		this.lineItems = lineItems;
	}
	
	public List<PaymentTransaction> getTransactions(){
		return transactions;
	}
	
	public void setTransactions(List<PaymentTransaction> transactions){
		this.transactions = transactions;
	}
	public boolean getIsDelivery() {
		return isDelivery;
	}
	public void setIsDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNum){
		this.phoneNumber = phoneNum;
	}
	
	public void checkIfPayed(){
		double runningTotal = 0;
		double amountPaid = 0;
		
		for(LineItem l : lineItems){
			runningTotal += l.getItem().getPrice();
		}
		
		for(PaymentTransaction t : transactions){
			amountPaid += t.getAmount();
		}
		
		if(amountPaid >= runningTotal)
			setStatus(OrderStatus.PAYED);
	}
}
