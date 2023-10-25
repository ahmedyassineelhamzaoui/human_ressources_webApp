package com.app.repository;

import com.app.util.HibernateUtil;

import java.util.List;

import com.app.entity.Order;
import jakarta.persistence.EntityManager;
public class OrderRepository {

	private EntityManager entityManager;
	public OrderRepository() {
		this.entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	public void addOrder(Order order) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(order);
			entityManager.getTransaction().commit();
			}catch(Exception e) {
				if(entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
			e.getMessage();
		}finally {
			entityManager.close();
		}
		
	}
	public List<Order> getAllOrders(){
		return entityManager.createQuery("SELECT o FROM Order o",Order.class).getResultList();
	}
	public Order findOrderById(long id) {
		return entityManager.find(Order.class, id);
	}
	public void deleteOrder(Order order) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(order);
			entityManager.getTransaction().commit();;
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}finally {
			entityManager.close();
		}
	}
}
