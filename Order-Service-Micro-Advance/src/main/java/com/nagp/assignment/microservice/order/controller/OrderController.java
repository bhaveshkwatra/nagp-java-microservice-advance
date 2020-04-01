package com.nagp.assignment.microservice.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignment.microservice.order.model.Order;
import com.nagp.assignment.microservice.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/{userId}")
	public List<Order> readOrderListByUser(@PathVariable String userId) {
		return orderService.getOrderByUserId(userId);
	}

}
