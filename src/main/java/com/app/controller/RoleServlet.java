package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.app.entity.Role;
import com.app.service.RoleService;

public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService;
	    public RoleServlet() {
	            super();
	    }
	    public void init() throws ServletException {
	        super.init();
	        this.roleService = new RoleService();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String roleName = request.getParameter("role");
	        if (roleName.trim().isEmpty()) {
	            // Role name is empty, redirect to the original URL with an error message
	            String errorMessage = "Role name cannot be empty";
	            response.sendRedirect("pages/tables/roles.jsp?error=" + URLEncoder.encode(errorMessage, StandardCharsets.UTF_8));
	            System.out.println("name can't be empty");
	        } else {
	            // Role name is not empty, proceed with role creation
	            Role role = new Role();
	            role.setName(roleName);
	            roleService.createRole(role);
	            PrintWriter pw = response.getWriter();
	            pw.print("Role created successfully");
	        }
	    }


}
