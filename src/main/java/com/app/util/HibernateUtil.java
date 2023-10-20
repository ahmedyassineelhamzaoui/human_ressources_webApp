package com.app.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory entityManagerFactory;

    private HibernateUtil() {};
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
            } catch (Exception e) {
                e.printStackTrace();
                if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                    entityManagerFactory.close();
                }
            }
        }
        return entityManagerFactory;
    }
}
