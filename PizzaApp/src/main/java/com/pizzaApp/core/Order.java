
package com.pizzaApp.core;

import java.util.Set;
import java.util.HashSet;
import java.util.UUID;

public class Order {

	private String id;
	private String timestamp;
	private OrderStatus status;
	private Set<LineItem> lineItems;
	private boolean isDelivery;

	public Order() {
		this.id = UUID.randomUUID().toString();
		timestamp = "" + System.currentTimeMillis() / 1000L;
		status = OrderStatus.OPEN;
		lineItems = new HashSet<LineItem>();
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

	public boolean getIsDelivery() {
		return isDelivery;
	}
	public void setIsDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}
}
