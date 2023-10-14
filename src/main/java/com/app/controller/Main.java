package com.app.controller;

import jakarta.persistence.EntityManagerFactory;


import com.app.util.HibernateUtil;

public class Main {
    private static EntityManagerFactory sessionFactory;

	public static void main(String[] args) {

        // Initialize Hibernate session factory
        sessionFactory = HibernateUtil.getEntityManagerFactory();
       
       System.out.println("Session factory is created in init: " + sessionFactory);

	}

}
