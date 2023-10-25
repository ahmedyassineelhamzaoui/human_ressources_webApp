package com.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.app.entity.Equipement;
import com.app.entity.Order;
import com.app.entity.User;
import com.app.service.EquipmentService;
import com.app.service.OrderService;
import com.app.service.UserService;
/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderService();
		List<Order> orders = orderService.getAllOrders();
		for(Order o:orders) {
			System.out.println(o.getUser().getEmail());
		}
		request.setAttribute("orders", orders);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderService();
		String reservationDate = request.getParameter("reservationDate");
		String returnDate      = request.getParameter("returnDate");
		String user_id         = request.getParameter("user");
		String equipmet_id     = request.getParameter("equipment");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Order order = new Order();
		UserService userService = new UserService();
		User user = userService.findUserById(Integer.parseInt(user_id));
		EquipmentService equipmentService = new EquipmentService();
		Equipement equipment = equipmentService.findById(Integer.parseInt(equipmet_id));
		order.setUser(user);
		order.setEquipement(equipment);
		try {
			Date reservationDateToSave = dateFormat.parse(reservationDate);
			Date returnDateToSave      = dateFormat.parse(returnDate);
			order.setDate_emprunt(reservationDateToSave);
			order.setDate_retour(returnDateToSave);
		}catch(Exception e) {
			e.getMessage();
		}
		orderService.addOrder(order);
		
	}

}
