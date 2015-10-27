


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

import com.pizzaApp.core.MenuItem;
import com.pizzaApp.core.Menu;

@RestController
public class MenuController {
	
	private final Menu menu;

	public MenuController() {
		menu = Menu.sharedInstance();
	}

	@RequestMapping(method=RequestMethod.GET, value="/menu")
	public List<MenuItem> getMenu() {
		return menu.list();
	}

	@RequestMapping(method=RequestMethod.GET, value="/menu/{menuItemId}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable(value="menuItemId") String id) {
		return new ResponseEntity<MenuItem>(menu.get(id), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, value="/menu")
	public MenuItem createMenuItem(@RequestBody final MenuItem item) {
		menu.addMenuItem(item);
		return item;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/menu/{menuItemId}")
	public ResponseEntity<MenuItem> updateMenuItem(@PathVariable(value="menuItemId") String id,
		@RequestBody final MenuItem item) {
		if(menu.get(id) ==  null) throw new MenuItemNotFoundException();
		menu.replace(id, item);
		return new ResponseEntity<MenuItem>(item, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/menu/{menuItemId}")
	public ResponseEntity<MenuItem> deleteMenuItem(@PathVariable(value="menuItemId") String id) {
		if(menu.get(id) == null) throw new MenuItemNotFoundException();
		return new ResponseEntity<MenuItem>(menu.removeById(id), HttpStatus.OK);
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Menu Item does not exist!")
	public class MenuItemNotFoundException extends RuntimeException {
	}
}
