package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.persistence.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.app.entity.Departement;
import com.app.service.DepartmentService;
import com.app.util.HibernateUtil;


public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService departmentService = new DepartmentService();
		String action=request.getParameter("action");
		if("deleteDepartment".equals(action)) {
			long departmentIdToDelete = Long.parseLong(request.getParameter("id"));
			departmentToDelete = departmentService.findById(departmentIdToDelete);
			if(departmentToDelete !=null) {
				departmentService.removeDepartment(departmentToDelete);
		        String success = "department deleted successfully";
		        response.sendRedirect(request.getContextPath() + "/pages/tables/DepartmentServlet?success="+URLEncoder.encode(success,StandardCharsets.UTF_8));
			}
			
		}else {
			List<Departement> departements = departmentService.getAllDepartment();
			request.setAttribute("departements", departements);
			RequestDispatcher dispatcher = request.getRequestDispatcher("department.jsp");
		    dispatcher.forward(request, response);
		}
		
		
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
		
		RequestDispatcher dispacher = null;

		
		if(name.trim().isEmpty()) {
			response.sendRedirect("addDepartment.jsp?errorName="+ URLEncoder.encode(errorName,StandardCharsets.UTF_8));
		}else
		if(description.trim().isEmpty()) {
			response.sendRedirect("addDepartment.jsp?errorDescription="+ URLEncoder.encode(errorDescription, StandardCharsets.UTF_8));
		}else
		if(headOfDepartment.trim().isEmpty()) {
			response.sendRedirect("addDepartment.jsp?errorheadOfDepartment="+ URLEncoder.encode(errorheadOfDepartment, StandardCharsets.UTF_8));
		}else {
			
			dispacher = request.getRequestDispatcher("department.jsp");
			DepartmentService departmentService = new DepartmentService();
			Departement d = new Departement();
			d.setName(name);
			d.setHeadOfDepartment(headOfDepartment);
			d.setDescription(description);
			departmentService.addDepartment(d);
			request.setAttribute("success", "department created successfuly");
			dispacher.forward(request, response);
		}
	}

}
