package com.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
        String err1="",err2="",err3="",err4="",err5="",err6="";
        if(userName.trim().isEmpty()) {
        	 err3 = "userNameError="+ URLEncoder.encode("username can't be empty", StandardCharsets.UTF_8);
        }
        if(firstName.trim().isEmpty()){
        	 err4 = "firstNameError="+ URLEncoder.encode("first name can't be empty", StandardCharsets.UTF_8);
        }
        if(lastName.trim().isEmpty()){
        	 err6 = "lastNameError="+ URLEncoder.encode("last name can't be empty", StandardCharsets.UTF_8);
        }
        if(email.trim().isEmpty()){
        	 err5 = "emailError="+ URLEncoder.encode("eamil can't be empty", StandardCharsets.UTF_8);
        }
        if(password.trim().isEmpty()){
        	 err2 = "passwordError="+ URLEncoder.encode("password can't be empty", StandardCharsets.UTF_8);
        }
        if(position.trim().isEmpty()){
        	 err1 = "positionError="+ URLEncoder.encode("position can't be empty", StandardCharsets.UTF_8);
        }
       
        if(!err1.isEmpty() || !err2.isEmpty() || !err3.isEmpty() || !err4.isEmpty() || !err5.isEmpty() || !err6.isEmpty()) {
        	response.sendRedirect("pages/tables/addUser.jsp?"+err1+"&"+err2+"&"+err3+"&"+err4+"&"+err5+"&"+err6);
        }else {
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

}
