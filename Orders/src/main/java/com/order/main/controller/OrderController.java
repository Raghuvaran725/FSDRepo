package com.order.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.main.entity.Orders;
import com.order.main.exception.OrderNotFoundException;
import com.order.main.service.OrderService;



@RestController
@RequestMapping("/orders")
public class OrderController {
	 	@Autowired
	    private OrderService orderService;


		@PostMapping("/")
		public ResponseEntity<Orders> addOrder(@RequestBody Orders order  ){
			Orders o= orderService.addOrder(order);
			return new ResponseEntity<>(o, HttpStatus.CREATED);
		}
		@GetMapping("/all")
	    public ResponseEntity<List<Orders>> getOrders() {
	        List<Orders> orderList = orderService.getOrders();
	        return new ResponseEntity<>(orderList, HttpStatus.OK);
	    }
		@GetMapping("/orderbyid")
	    public ResponseEntity<Orders> getOrder(@RequestParam("oid") int oid) throws OrderNotFoundException {
			Orders order = orderService.getOrder(oid);
			return new ResponseEntity<>(order, HttpStatus.OK);
		}
		@DeleteMapping("/delete")
		public ResponseEntity<Map<String, String>> deleteOrder(@RequestParam("oid") int oid) throws OrderNotFoundException {
			Map<String, String> response = new HashMap<>();
			boolean deleted = orderService.deleteOrder(oid);
			if (deleted) {
				response.put("deleted", "yes");
			} else {
				response.put("deleted", "no");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
			}
		@PutMapping("/update")
		public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
			Orders o = orderService.updateOrder(order);
			return new ResponseEntity<>(o, HttpStatus.CREATED);
			}	
		
}
