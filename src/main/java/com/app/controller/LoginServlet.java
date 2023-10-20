package com.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.*;
import com.app.entity.User;
import com.app.service.UserService;
import com.app.util.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userLogin = request.getParameter("userLogin");
		String password = request.getParameter("password");
		EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserService us = new UserService(entityManager);
		User user = us.findByUserLogin(userLogin);
		if(user !=null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
			   HttpSession session = request.getSession();
			   session.setAttribute("user", user);
			   response.sendRedirect("pages/tables/UserServlet");
			}else {
				String errorMessage ="error="+URLEncoder.encode("invalid password",StandardCharsets.UTF_8);
				response.sendRedirect("login.jsp?"+errorMessage);
			}
		}else {
			String errorMessage = "error="+URLEncoder.encode("username not exist",StandardCharsets.UTF_8);
			response.sendRedirect("login.jsp?"+errorMessage);
		}
			
	}

}
