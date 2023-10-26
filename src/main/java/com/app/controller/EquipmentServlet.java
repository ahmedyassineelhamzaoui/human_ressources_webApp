package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.entity.Equipement;
import com.app.entity.User;
import com.app.service.EquipmentService;
import com.app.service.UserService;
import java.util.*;
/**
 * Servlet implementation class EquipmentServlet
 */
public class EquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("equipmentId") !=null) {
			EquipmentService equipmentService = new EquipmentService();
			long equipmentId = Integer.parseInt(request.getParameter("equipmentId"));
			Equipement equipment = equipmentService.findById(equipmentId);
			try {
				equipmentService.deleteEquipment(equipment);
				response.setStatus(HttpServletResponse.SC_OK);
			}catch(Exception e) {
				e.getMessage();
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
		}else {
			EquipmentService equipmentServlet = new EquipmentService(); 
	        List<Equipement> equipments = equipmentServlet.getAllEquipment();
	        request.setAttribute("equipments", equipments);
			RequestDispatcher dispatcher = request.getRequestDispatcher("equipment.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String purchaseDateStr =request.getParameter("purchaseDate");
		String maintenaceDateStr =request.getParameter("maintenaceDate");
		String status =request.getParameter("status");
		String type =request.getParameter("type");
		String user_id =request.getParameter("user");
		UserService  userService = new UserService();
		User user = userService.findUserById(Integer.parseInt(user_id));
		EquipmentService equipmentService = new EquipmentService();
		Equipement e = new Equipement();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date purchaseDate = dateFormat.parse(purchaseDateStr);
		    Date maintenanceDate = dateFormat.parse(maintenaceDateStr);
		    e.setMaintenanceDate(maintenanceDate);
		    e.setPurchaseDate(purchaseDate);
		}catch(Exception es) {
			es.getMessage();
	    }
		
	    e.setName(name);
	    e.setStatus(status);
	    e.setType(type);
	    e.setAssignedUser(user);
	    equipmentService.SaveEquipment(e);
	    String successMessage = "success="+ URLEncoder.encode("equipment created successfuly",StandardCharsets.UTF_8);
    	response.sendRedirect("EquipmentServlet?"+successMessage);
	}

}
