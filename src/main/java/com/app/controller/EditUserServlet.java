package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.List;

import com.app.entity.User;

import com.app.entity.Departement;

import com.app.entity.Role;

import com.app.service.DepartmentService;
import com.app.service.RoleService;
import com.app.service.UserService;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditUserServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserService userService = new UserService();
		
		RoleService roleService = new RoleService();
		
		DepartmentService departmentService = new DepartmentService();
		
		List<Role> roles = roleService.getAllRoles();
		
		request.setAttribute("roles", roles);
		
		List<Departement> departments = departmentService.getAllDepartment();
		
		request.setAttribute("departments", departments);
		
		User user = userService.findUserById(Integer.parseInt(id));
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
