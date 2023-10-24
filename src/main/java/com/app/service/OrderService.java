package com.app.service;

import com.app.repository.OrderRepository;
import com.app.entity.Order;
public class OrderService {

	private OrderRepository orderRepository;
	public OrderService() {
		this.orderRepository = new OrderRepository();
	}
	public void addOrder(Order order) {
		orderRepository.addOrder(order);
	}
}
