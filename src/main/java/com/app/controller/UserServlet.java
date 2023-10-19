package com.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.app.entity.Departement;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.service.UserService;
import com.app.util.HibernateUtil;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String role_id = request.getParameter("role");
        String departement_id = request.getParameter("departement");
        PrintWriter pw = response.getWriter();
        pw.println(userName + firstName + lastName + email +password + position + role_id + departement_id);
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        UserService userService = new UserService(entityManager);
        
        
        Role role = entityManager.find(Role.class, role_id); 
        Departement department = entityManager.find(Departement.class, departement_id); 
            
            
        User newUser = new User();
        newUser.setUsername(userName);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPosition(position);
        newUser.setRole(role);
        newUser.setDepartment(department);
        userService.addUser(newUser);
	         
	}

}
