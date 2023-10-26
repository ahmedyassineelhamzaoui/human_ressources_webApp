package com.app.repository;

import java.util.List;

import com.app.entity.Task;
import com.app.util.HibernateUtil;

import jakarta.persistence.EntityManager;

public class TaskRepository {

	private EntityManager entityManager;
	
	public TaskRepository() {
		this.entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
	}
	public void addTask(Task task) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(task);
			entityManager.getTransaction().commit();
		}catch(Exception e) {
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}finally {
			entityManager.close();
		}
	}
	public void deleteTask(Task task) {
		entityManager.getTransaction().begin();
		entityManager.remove(task);
		entityManager.getTransaction().commit();
	}
	public Task findById(long id) {
		return entityManager.find(Task.class,id);
	}
	public List<Task> getAllTasks(){
		return entityManager.createQuery("SELECT t From Task t",Task.class).getResultList();
	}
	public void updateTask(Task task) {
		entityManager.getTransaction().begin();
		 entityManager.merge(task);
		 entityManager.getTransaction().commit();
	}
}
