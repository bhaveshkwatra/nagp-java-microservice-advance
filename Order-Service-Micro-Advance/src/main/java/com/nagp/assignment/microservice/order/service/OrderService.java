package com.nagp.assignment.microservice.order.service;

import java.util.List;

import com.nagp.assignment.microservice.order.model.Order;

public interface OrderService {
	
	List<Order> getOrderByUserId(String userId);

}
