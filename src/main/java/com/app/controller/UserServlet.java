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
import java.io.PrintWriter;
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

	        // Begin a transaction
	        entityManager.getTransaction().begin();

	        try {
	            // Create a new User
	            User newUser = new User();
	            
	            newUser.setUsername("newuser");
	            newUser.setPassword("password");
	            newUser.setFirstName("John");
	            newUser.setLastName("Doe");
	            newUser.setEmail("john.doe@example.com");
	            newUser.setPosition("Developer");

	            Role role = entityManager.find(Role.class, 1); 
	            Departement department = entityManager.find(Departement.class, 1); 
	            newUser.setRole(role);
	            newUser.setDepartment(department);

	            // Persist the User to the database
	            entityManager.persist(newUser);

	            // Commit the transaction
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            // Handle exceptions (e.g., validation errors)
	            entityManager.getTransaction().rollback();
	            e.printStackTrace();
	        } finally {
	            // Close the EntityManager and the EntityManagerFactory
	            entityManager.close();
	        }
	    }

}
