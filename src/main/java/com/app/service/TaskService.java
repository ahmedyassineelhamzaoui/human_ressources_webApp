package com.app.service;

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
}
