package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.app.entity.User;

import com.app.entity.Departement;

import com.app.entity.Role;

import com.app.service.DepartmentService;
import com.app.service.RoleService;
import com.app.service.UserService;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditUserServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserService userService = new UserService();
		
		RoleService roleService = new RoleService();
		
		DepartmentService departmentService = new DepartmentService();
		
		List<Role> roles = roleService.getAllRoles();
		
		request.setAttribute("roles", roles);
		
		List<Departement> departments = departmentService.getAllDepartment();
		
		request.setAttribute("departments", departments);
		
		User user = userService.findUserById(Integer.parseInt(id));
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
		
		dispatcher.forward(request, response);
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
        String emailRegex = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
        
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
        if(position.trim().isEmpty()){
        	 err1 = "positionError="+ URLEncoder.encode("position can't be empty", StandardCharsets.UTF_8);
        }
       
        if(!err1.isEmpty() || !err2.isEmpty() || !err3.isEmpty() || !err4.isEmpty() || !err5.isEmpty() || !err6.isEmpty()) {
        	response.sendRedirect("pages/tables/editUser.jsp?"+err1+"&"+err2+"&"+err3+"&"+err4+"&"+err5+"&"+err6);
        }else {
            UserService userService = new UserService();
            
            User usertoEdit = userService.findByUserLogin(userName);
            
            Role role = userService.findRoleById(Integer.parseInt(role_id)); 
            Departement department = userService.findDepartementById(Integer.parseInt(departement_id)); 
                
                
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
            userService.updateUser(newUser);
            String successMessage = "success="+ URLEncoder.encode("user updated successfuly",StandardCharsets.UTF_8);
        	response.sendRedirect("UserServlet?"+successMessage);
        }
	}

}
