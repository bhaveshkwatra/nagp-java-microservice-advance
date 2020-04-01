package com.nagp.assignment.microservice.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.assignment.microservice.aggregator.model.UserOrderDetail;
import com.nagp.assignment.microservice.aggregator.service.OrderDetailService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping("/{userId}")
	public UserOrderDetail readUserOrderDetails(@PathVariable final String userId) {
		return orderDetailService.getUserOrderDetail(userId);
	}
	
}
