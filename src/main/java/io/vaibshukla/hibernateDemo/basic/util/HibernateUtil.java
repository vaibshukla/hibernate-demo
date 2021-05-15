package io.vaibshukla.hibernateDemo.basic.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static  SessionFactory sessionFactory;


    private static SessionFactory setupSessionFactory() {
       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            return sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null ) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    sessionFactory = setupSessionFactory();
                }
            }
        }

        return sessionFactory;
    }

    public static  void  close() {
        if (sessionFactory != null ) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory != null) {
                    sessionFactory.close();
                }
            }
        }


    }
}
