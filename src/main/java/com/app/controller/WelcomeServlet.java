package com.app.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.app.entity.Departement;
import com.app.service.DepartmentService;
import com.app.util.HibernateUtil;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		DepartmentService ds = new DepartmentService();
//		List<Departement> departements = ds.getAllDepartment();
//        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
//		List<Departement> deleteDepartmentList =  departements.stream()
//			    .filter(entity -> entity.getName().contains("a")) 
//			    .sorted(Comparator.comparing(Departement::getName))
//			    .peek(entity -> {
//			        EntityTransaction transaction = entityManager.getTransaction();
//			        transaction.begin();
//			        entityManager.remove(entity);
//			        transaction.commit();
//			    })
//			    .collect(Collectors.toList());
//		for (Departement department : deleteDepartmentList) {
//		    System.out.println(department);
//		}
		
		
		
		PrintWriter pw = response.getWriter();
		pw.print("hi");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
