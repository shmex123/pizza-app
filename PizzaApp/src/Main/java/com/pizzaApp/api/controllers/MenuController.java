


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

import com.pizzaApp.api.models.MenuItem;

@RestController
public class MenuController {
	
	private final Map<String, MenuItem> menu;

	public MenuController() {
		menu = new HashMap<String, MenuItem>();
	}

	@RequestMapping(method=RequestMethod.GET, value="/menu")
	public List<MenuItem> getMenu() {
		synchronized(menu) {
			return new ArrayList<MenuItem>(menu.values());
		}
	}

	@RequestMapping(method=RequestMethod.POST, value="/menu")
	public MenuItem createMenuItem(@RequestBody final MenuItem item) {
		synchronized(menu) {
			menu.put(item.getId(), item);
		}
		return item;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/menu/{menuItemId}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable(value="menuItemId") String id,
		@RequestBody final MenuItem item) {
		if(menu.get(id) ==  null) throw new MenuItemNotFoundException();
		menu.put(id, item);
		return new ResponseEntity<MenuItem>(item, HttpStatus.OK);
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Menu Item does not exist!")
	public class MenuItemNotFoundException extends RuntimeException {
	}
}
