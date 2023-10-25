package com.app.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import com.app.entity.Departement;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.service.UserService;
import com.google.gson.Gson;

import java.util.Date;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getParameter("userId") !=null) {
			long userId = Integer.parseInt(request.getParameter("userId"));
			try {
				UserService userService = new UserService();
				userService.deleteUser(userId);
				response.setStatus(HttpServletResponse.SC_OK);
			}catch (Exception e) {
			    e.printStackTrace(); 
			    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
	    }else if(request.getParameter("editId") !=null){
	    	long editId = Integer.parseInt(request.getParameter("editId"));
			try {
				UserService userService = new UserService();
				User user = userService.findUserById(editId);	        
		        response.getWriter().write("users");
				response.setStatus(HttpServletResponse.SC_OK);
			}catch (Exception e) {
			    e.printStackTrace(); 
			    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
	    }else {

	    	UserService userService = new UserService();
			List<User> users = userService.getAllUsers();
			RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
			request.setAttribute("users", users);
			dispatcher.forward(request,response);
	    }
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String position = request.getParameter("position");
        String hireDate = request.getParameter("hireDate");
        String role_id = request.getParameter("role");
        String departement_id = request.getParameter("departement");
        String emailRegex = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
		String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$";
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
        if(email.trim().isEmpty() || !email.matches(emailRegex)){
        	 err5 = "emailError="+ URLEncoder.encode("invalid email", StandardCharsets.UTF_8);
        }
        if(password.trim().isEmpty() || !password.matches(passwordRegex)){
        	 err2 = "passwordError="+ URLEncoder.encode("invalid password", StandardCharsets.UTF_8);
        }
        if(position.trim().isEmpty()){
        	 err1 = "positionError="+ URLEncoder.encode("position can't be empty", StandardCharsets.UTF_8);
        }
       
        if(!err1.isEmpty() || !err2.isEmpty() || !err3.isEmpty() || !err4.isEmpty() || !err5.isEmpty() || !err6.isEmpty()) {
        	response.sendRedirect("pages/tables/addUser.jsp?"+err1+"&"+err2+"&"+err3+"&"+err4+"&"+err5+"&"+err6);
        }else {
            UserService userService = new UserService();
            

            
            Role role = userService.findRoleById(Integer.parseInt(role_id)); 
            Departement department = userService.findDepartementById(Integer.parseInt(departement_id)); 
                
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            User newUser = new User();
            newUser.setUsername(userName);
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            newUser.setPassword(hashedPassword);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setPosition(position);
            newUser.setRole(role);
            newUser.setDepartment(department);
            try {
            	Date hireDateToInsert = dateFormat.parse(hireDate);
                newUser.setHireDate(hireDateToInsert);

            }catch(Exception e) {
            	e.getMessage();
            }
            userService.addUser(newUser);

            String successMessage = "success="+ URLEncoder.encode("user created successfuly",StandardCharsets.UTF_8);
        	response.sendRedirect("UserServlet?"+successMessage);
        }
        
        
        
        
        
	         
	}

}
