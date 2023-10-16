package com.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.app.entity.Departement;
import com.app.entity.Role;
import com.app.entity.User;
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
	        // Create an EntityManager (per transaction or request)
	        EntityManager entityManager = 	HibernateUtil.getEntityManagerFactory().createEntityManager();

	        // Begin a transaction
	        entityManager.getTransaction().begin();

	        try {
	            // Create a new User
	            User newUser = new User();
	            // Create a new Role
	            Role newRole = new Role();
	            newRole.setName(request.getParameter("user"));

	            // Create a new Departement
	            Departement newDepartement = new Departement();
	            
	            newUser.setDepartment(newDepartement);

	            // Set the hireDate in the newEmployee object
	            
	            newDepartement.setName("info");
	            newUser.setFirstName("ahmed");
	            newUser.setUsername("yassine09");
	            newUser.setPassword("error404@");
	            newUser.setLastName("yassine");
	            newUser.setEmail("ahmed@gmail.com");
	            newUser.setPosition("position1");

	           

	            // Associate User with Role and Departement
	            newUser.setRole(newRole);

	            // Persist the User to the database
	            entityManager.persist(newUser);

	            // Commit the transaction
	            entityManager.getTransaction().commit();

	            // Redirect to a success page or send a response
	            response.sendRedirect("index.jsp");
	        } catch (Exception e) {
	            // Handle exceptions (e.g., validation errors)
	        	System.out.println(e.getMessage());
	            entityManager.getTransaction().rollback();
	            response.sendRedirect("error.jsp");
	        } finally {
	            // Close the EntityManager and the EntityManagerFactory
	            entityManager.close();
	        }
	    }

}
