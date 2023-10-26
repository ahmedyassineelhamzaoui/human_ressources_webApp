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
        String email = request.getParameter("email");
        String role_id = request.getParameter("role");
        String departement_id = request.getParameter("departement");
        String emailRegex = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
        
        String err1="",err2="",err3="",err4="",err5="",err6="";
       
        if(email.trim().isEmpty() || !email.matches(emailRegex)){
        	 err5 = "emailError="+ URLEncoder.encode("invalid email", StandardCharsets.UTF_8);
        }
       
        if( !err5.isEmpty()) {
        	response.sendRedirect("pages/tables/UserServlet.jsp?"+err5);
        }else {
            UserService userService = new UserService();
            
            User usertoEdit = userService.findByUserLogin(email);
            
            Role role = userService.findRoleById(Integer.parseInt(role_id)); 
            Departement department = userService.findDepartementById(Integer.parseInt(departement_id)); 

            User newUser = new User();
            newUser.setEmail(email);
            newUser.setRole(role);
            newUser.setDepartment(department);
            userService.updateUser(newUser,usertoEdit.getId());
            String successMessage = "success="+ URLEncoder.encode("user updated successfuly",StandardCharsets.UTF_8);
        	response.sendRedirect("UserServlet?"+successMessage);
        }
	}

}
