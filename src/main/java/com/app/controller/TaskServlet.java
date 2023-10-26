package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.app.entity.Task;
import com.app.entity.User;
import com.app.service.TaskService;
import com.app.service.UserService;

/**
 * Servlet implementation class TaskServlet
 */
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskService taskService = new TaskService(); 
		List<Task> tasks = taskService.getAllTasks();
		request.setAttribute("tasks", tasks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("task.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deadline=request.getParameter("deadline");
		String description=request.getParameter("description");
		String priority=request.getParameter("priority");
		String status=request.getParameter("status");
		String user_id=request.getParameter("user");
      
		UserService userService = new UserService();
		User user = userService.findUserById(Integer.parseInt(user_id));
		Task t = new Task();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date deadlineDate = dateFormat.parse(deadline);
			t.setDeadline(deadlineDate);
		}catch(Exception e) {
			e.getMessage();
		}
		t.setDescription(description);
		t.setPriority(priority);
		t.setStatus(status);
		t.setAssignedUser(user);
		TaskService taskService = new TaskService();
		taskService.addTask(t);
	}

}
