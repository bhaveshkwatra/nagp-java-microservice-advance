package com.nagp.assignment.microservice.order.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagp.assignment.microservice.order.data.MockData;
import com.nagp.assignment.microservice.order.model.Order;
import com.nagp.assignment.microservice.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getOrderByUserId(String userId) {
		return MockData.getInstance().getOrderDataByOrderId(userId);
	}

}
