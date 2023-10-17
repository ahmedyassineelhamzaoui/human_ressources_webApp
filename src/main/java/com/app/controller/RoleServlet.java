package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.app.entity.Role;
//import com.app.repository.RoleRepository;
//import com.app.service.RoleService;


public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private RoleService roleService;
//	    public RoleServlet() {
//	            super();
//	    }
//	    public void init() throws ServletException {
//	        super.init();
//	        roleService = new RoleService();
//	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String roleName = request.getParameter("role");
	        Role role = new Role();
	        role.setName(roleName);

	       // roleService.createRole(role);

	        PrintWriter pw = response.getWriter();
	        pw.print("Role created successfully");
	    }


}
