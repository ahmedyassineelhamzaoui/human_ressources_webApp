package com.app.service;

import java.util.List;

import com.app.entity.Task;
import com.app.repository.TaskRepository;

public class TaskService {

	private TaskRepository taskRepository;
	
	public TaskService() {
		this.taskRepository = new TaskRepository();
	}
	public void addTask(Task task) {
		taskRepository.addTask(task);
	}
	public List<Task> getAllTasks(){
		return taskRepository.getAllTasks();
	}
	public void deleteTask(Task task) {
		taskRepository.deleteTask(task);
	}
	public Task findById(long id) {
		return taskRepository.findById(id);
	}
	public void updateTask(Task task) {
		 taskRepository.updateTask(task);
	}
}
