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
import com.app.entity.Task;
import com.app.service.TaskService;
import com.app.service.UserService;
import com.app.entity.User;
/**
 * Servlet implementation class EditTaskServlet
 */
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		TaskService taskService = new TaskService();
		Task task = taskService.findById(Integer.parseInt(id));
		request.setAttribute("task", task);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editTask.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String deadline=request.getParameter("deadline");
		String description=request.getParameter("description");
		String priority=request.getParameter("priority");
		String status=request.getParameter("status");
		String user_id=request.getParameter("user");
		TaskService taskService = new TaskService();
		Task task = taskService.findById(Integer.parseInt(id));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date deadlineDate = dateFormat.parse(deadline);
			task.setDeadline(deadlineDate);

		}catch(Exception e) {
			e.getMessage();
		}
		UserService userService = new UserService();
		User user = userService.findUserById(Integer.parseInt(user_id));
		task.setAssignedUser(user);
		task.setDescription(description);
		task.setPriority(priority);
		task.setStatus(status);
		taskService.updateTask(task);
		PrintWriter pw = response.getWriter();
		
		pw.print("id: "+task.getId()+" deadline: "+task.getDeadline()+" description: "+task.getDescription()+" priority:"+task.getPriority()+" status: "+task.getStatus()+" user_id: "+task.getAssignedUser());
	}

}
