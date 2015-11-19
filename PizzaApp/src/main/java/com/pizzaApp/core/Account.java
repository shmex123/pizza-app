package com.pizzaApp.core;

import java.util.UUID;

public class Account {

	private String id;
	private String email;
	private String password;
	private int points; 
	
	public Account(){
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void setPoints(int points){
		this.points = points;
	}
}

