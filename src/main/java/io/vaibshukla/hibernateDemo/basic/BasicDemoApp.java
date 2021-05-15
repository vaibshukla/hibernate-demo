package io.vaibshukla.hibernateDemo.basic;

import io.vaibshukla.hibernateDemo.basic.entity.User;
import io.vaibshukla.hibernateDemo.basic.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;

@Slf4j
public class BasicDemoApp {

    public static void main(String[] args) {

        // Obtain Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(User.builder().firstName("Vaibhav").lastName("Shukla").build());
        session.save(User.builder().firstName("John").lastName("Doe").build());
        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();

        log.info(" Users : {} " , users);


    }
}
