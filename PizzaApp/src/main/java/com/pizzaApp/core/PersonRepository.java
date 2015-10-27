package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import JunitTests.Person;

public class PersonRepository {

		private static PersonRepository instance = new PersonRepository();
		private Map<String, Person> users; //The person's name is the key for this hashMap
		
		private PersonRepository(){
			users = new HashMap<String, Person>();
		}
		
		public static PersonRepository sharedInstance(){
			return instance;
		}
		
		public Person get(String name){
			synchronized(users){
				return users.get(name);
			}
		}
		
		public void add(Person user){
			synchronized(users){
				this.users.put(user.getName(), user);
			}
		}
		
		public void replace(Person user){
			synchronized(users){
				this.users.put(user.getName(), user);
			}
		}
		
		public Person removeById(String id){
			synchronized(users){
				return this.users.remove(id);
			}
		}
		
		public List<Person> list(){
			synchronized(users){
				return new ArrayList<Person>(users.values());
			}
		}
		
		
		//create some person data so we have 3 perspectives
		public void createSeedData(){
			Address customerAddress = new Address("2584 stevie dr", null, "Steville", "CO", "808080", "USA");
			
			Person customer = new Person("connie smeve", "connieIsSmevesWife@match.com", "1112223334", customerAddress);
			Person manager = new Person("jon nobody", "jonisAnobody@gmail.com", "3033331517");
			Person cook = new Person("steve smeve", "stevethinksHesgreat@ymail.com", "1112223334", "2584 stevie dr", null, "Steville", "CO", "808080", "USA");
			Person employee = new Person("jon employee", "jonisAnobody@gmail.com", "3033331517");
			
			customer.setType(PersonType.CUSTOMER);
			manager.setType(PersonType.MANAGER);
			cook.setType(PersonType.COOK);
			employee.setType(PersonType.EMPLOYEE);
			
			users.put(customer.getName(), customer);
			users.put(manager.getName(), manager);
			users.put(cook.getName(), cook);
			users.put(employee.getName(), employee);
		}
}
