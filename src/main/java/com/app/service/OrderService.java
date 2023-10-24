package com.app.service;

import com.app.repository.OrderRepository;

import java.util.List;

import com.app.entity.Order;
public class OrderService {

	private OrderRepository orderRepository;
	public OrderService() {
		this.orderRepository = new OrderRepository();
	}
	public void addOrder(Order order) {
		orderRepository.addOrder(order);
	}
	public List<Order> getAllOrders(){
		return orderRepository.getAllOrders();
	}
	public Order findOrderById(long id) {
		return orderRepository.findOrderById(id);
	}
}
