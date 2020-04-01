package com.nagp.assignment.microservice.order.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagp.assignment.microservice.order.model.Order;

public class MockData {
	
	private static final MockData INSTANCE = new MockData();
	
	private final Map<String, List<Order>> userOrderData = new HashMap<>();
	
	private MockData() {
		loadData();
	}
	
	public static MockData getInstance() {
		return INSTANCE;
	}
	
	private void loadData() {
		List<Order> orderList = new ArrayList<>();
		
		// Order 1 - User 1
		Order order = new Order();
		
		order.setId("O001");
		order.setAmount(200);
		order.setDate("23-03-2020");
		
		orderList.add(order);
		
		// Order 2 - User 1
		order = new Order();
		
		order.setId("O002");
		order.setAmount(300);
		order.setDate("24-03-2020");
		
		orderList.add(order);
		
		// insert the order list for user-1in map
		userOrderData.put("1", orderList);
		
		orderList = new ArrayList<>();
		
		// Order 1 - User 2
		order = new Order();
		
		order.setId("O003");
		order.setAmount(500);
		order.setDate("26-03-2020");
		
		orderList.add(order);
		
		// Order 2 - User 2
		order = new Order();
		
		order.setId("O004");
		order.setAmount(600);
		order.setDate("27-03-2020");
		
		orderList.add(order);
		
		// insert the order list for user user-2 in map
		userOrderData.put("2", orderList);
		
		orderList = new ArrayList<>();
		
		// Order 1 - User 3
		order = new Order();
		
		order.setId("O005");
		order.setAmount(500);
		order.setDate("28-03-2020");
		
		orderList.add(order);
		
		// insert the order list for user-3 in map
		userOrderData.put("3", orderList);
	}
	
	public List<Order> getOrderDataByOrderId(String userId) {
		return userOrderData.get(userId);
	}
}
