package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.app.entity.Departement;
import com.app.util.HibernateUtil;


public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory entityManagaerFactory = HibernateUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagaerFactory.createEntityManager();
		
		String name = request.getParameter("name");
		String headOfDepartment = request.getParameter("headOfDepartment");
		String description = request.getParameter("description");
		
		String errorName = "Name can't be empty";
		String errorDescription = "Description can't be empty";
		String errorheadOfDepartment = "headOfDepartment can't be empty";
		
		if(name.trim().isEmpty()) {
			response.sendRedirect("pages/tables/department.jsp?errorName="+ URLEncoder.encode(errorName,StandardCharsets.UTF_8));
		}else
		if(description.trim().isEmpty()) {
			response.sendRedirect("pages/tables/roles.jsp?errorDescription="+ URLEncoder.encode(errorDescription, StandardCharsets.UTF_8));
		}else
		if(headOfDepartment.trim().isEmpty()) {
			response.sendRedirect("pages/tables/roles.jsp?errorheadOfDepartment="+ URLEncoder.encode(errorheadOfDepartment, StandardCharsets.UTF_8));
		}else {
	
			Departement d = new Departement();
			d.setName(name);
			d.setHeadOfDepartment(headOfDepartment);
			d.setDescription(description);
		}
	}

}
