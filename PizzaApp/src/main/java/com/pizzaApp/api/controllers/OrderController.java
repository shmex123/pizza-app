


package com.pizzaApp.api.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaApp.core.Order;
import com.pizzaApp.core.OrderRepository;

@RestController
public class OrderController {
	
	private OrderRepository repo;

	public OrderController() {
		repo = OrderRepository.sharedInstance();
	}

	@RequestMapping(method=RequestMethod.GET, value="/orders")
	public List<Order> getOrder() {
		return repo.list();
	}

	@RequestMapping(method=RequestMethod.GET, value="/orders/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable(value="orderId") String id) {
		Order o = repo.get(id);
		if(o == null) {
			throw new OrderNotFoundException();
		}
		return new ResponseEntity<Order>(repo.get(id), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, value="/orders")
	public ResponseEntity<Order> createOrder(@RequestBody final Order order) {
		repo.add(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/orders/{orderId}")
	public ResponseEntity<Order> updateMenuItem(@PathVariable(value="orderId") String id,
		@RequestBody final Order order) {
		if(repo.get(id) ==  null) throw new OrderNotFoundException();
		repo.replace(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/orders/{orderId}")
	public ResponseEntity<Order> deleteMenuItem(@PathVariable(value="orderId") String id) {
		if(repo.get(id) == null) throw new OrderNotFoundException();
		return new ResponseEntity<Order>(repo.removeById(id), HttpStatus.OK);
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Order does not exist!")
	public class OrderNotFoundException extends RuntimeException {
	}
}
