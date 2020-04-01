package com.nagp.assignment.microservice.aggregator.service;

import com.nagp.assignment.microservice.aggregator.model.UserOrderDetail;

public interface OrderDetailService {
	
	public UserOrderDetail getUserOrderDetail(String userId);

}
