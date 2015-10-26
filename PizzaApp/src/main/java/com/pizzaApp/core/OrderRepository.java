

package com.pizzaApp.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class OrderRepository {

	private static OrderRepository instance = new OrderRepository();
	private Map<String, Order> orders;
	
	private OrderRepository() {
		orders = new HashMap<String, Order>();
	}

	public static OrderRepository sharedInstance() {
		return instance;
	}

	public Order get(String id) {
		synchronized(orders) {
			return orders.get(id);
		}
	}

	public void add(Order order) {
		synchronized(orders) {
			this.orders.put(order.getId(), order);
		}
	}

	public List<Order> list() {
		synchronized(orders) {
			return new ArrayList<Order>(orders.values());
		}
	}
}
