package com.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.RequestDispatcher;
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
import com.app.util.HibernateUtil;

public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService roleService;
	    public RoleServlet() {
	            super();
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = "yassine";
	        request.setAttribute("name", name);
	        request.getRequestDispatcher("/pages/tables/roles.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        RoleService roleService = new RoleService(entityManager);
	    	String roleName = request.getParameter("role");
	        if (roleName.trim().isEmpty()) {
	            String errorMessage = "Role name cannot be empty";
	            response.sendRedirect("pages/tables/roles.jsp?error=" + URLEncoder.encode(errorMessage, StandardCharsets.UTF_8));
	            System.out.println("name can't be empty");
	        } else {
	            Role role = new Role();
	            role.setName(roleName);
	            roleService.createRole(role);
	            String successMessage="role created successfuly";
	            response.sendRedirect("pages/tables/roles.jsp?success="+URLEncoder.encode(successMessage,StandardCharsets.UTF_8));
	        }
	    }


}
