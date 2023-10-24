package com.app.service;

import com.app.repository.OrderRepository;

public class OrderService {

	private OrderRepository orderRepository;
	public OrderService() {
		this.orderRepository = new OrderRepository();
	}
}
