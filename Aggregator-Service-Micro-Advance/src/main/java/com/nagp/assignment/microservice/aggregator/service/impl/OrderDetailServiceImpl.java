package com.nagp.assignment.microservice.aggregator.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.assignment.microservice.aggregator.model.Order;
import com.nagp.assignment.microservice.aggregator.model.User;
import com.nagp.assignment.microservice.aggregator.model.UserOrderDetail;
import com.nagp.assignment.microservice.aggregator.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${USERSERVICE_URL:http://localhost:8056}")
	private String userUrl;
	
	@Value("${ORDERSERVICE_URL:http://localhost:8058}")
	private String orderUrl;
	
	

	@Override
	public UserOrderDetail getUserOrderDetail(String userId) {
		
		LOGGER.info(String.format("Order Details for user id : %s",userId));
		
		UserOrderDetail userOrderdetail = new UserOrderDetail();
		
		String fetchUserByIdUrl = String.format("%s/user/%s", userUrl, userId);
		
		String fetchOrderByUserId = String.format("%s/order/%s", orderUrl, userId);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("User service endpoint : %s",fetchUserByIdUrl));
		}
		
		ResponseEntity<User> userService  = restTemplate.exchange(fetchUserByIdUrl, HttpMethod.GET, null, User.class);
		
		if (userService.getStatusCode() != HttpStatus.OK) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("User service Status code : %s", userService.getStatusCode().getReasonPhrase()));
			}
			
			LOGGER.error("Either there is some issue in User Service or currently it's down");
			throw new RuntimeException();
		}
		
		userOrderdetail.setUser(userService.getBody());
		
		ResponseEntity<Order[]> orders = restTemplate.exchange(fetchOrderByUserId, HttpMethod.GET, null, Order[].class);
		

		if (userService.getStatusCode() != HttpStatus.OK) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(String.format("Order service Status code : %s", userService.getStatusCode().getReasonPhrase()));
			}
			
			throw new RuntimeException();
		}
		
		userOrderdetail.setOrders(Arrays.asList(orders.getBody()));
		return userOrderdetail;
	}

}
 