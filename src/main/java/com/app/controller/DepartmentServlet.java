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
			Departement departmentToDelete = departmentService.findById(departmentIdToDelete);
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
	    String name = request.getParameter("name");
	    String headOfDepartment = request.getParameter("headOfDepartment");
	    String description = request.getParameter("description");

	    String errorName = "Name can't be empty";
	    String errorDescription = "Description can't be empty";
	    String errorheadOfDepartment = "headOfDepartment can't be empty";

	    if (name.trim().isEmpty() || description.trim().isEmpty() || headOfDepartment.trim().isEmpty()) {
	        String redirectURL = "addDepartment.jsp?";
	        if (name.trim().isEmpty()) {
	            redirectURL += "errorName=" + URLEncoder.encode(errorName, StandardCharsets.UTF_8);
	        }
	        if (description.trim().isEmpty()) {
	            redirectURL += "&errorDescription=" + URLEncoder.encode(errorDescription, StandardCharsets.UTF_8);
	        }
	        if (headOfDepartment.trim().isEmpty()) {
	            redirectURL += "&errorheadOfDepartment=" + URLEncoder.encode(errorheadOfDepartment, StandardCharsets.UTF_8);
	        }
	        response.sendRedirect(redirectURL);
	    } else {
	        DepartmentService departmentService = new DepartmentService();
	        Departement d = new Departement();
	        d.setName(name);
	        d.setHeadOfDepartment(headOfDepartment);
	        d.setDescription(description);
	        departmentService.addDepartment(d);
	        response.sendRedirect("DepartmentServlet");
	    }
	}


}
