package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.app.entity.Task;
import com.app.service.TaskService;

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
		PrintWriter pw = response.getWriter();
		pw.print("id: "+id+" deadline: "+deadline+" description: "+description+" priority:"+priority+" status: "+status+" user_id: "+user_id);
	}

}
