package io.vaibshukla.hibernateDemo.basic;

import io.vaibshukla.hibernateDemo.basic.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Slf4j
public class JpaDemo {


    public static void main(String[] args) {

        // Obtain Session
        EntityManager entityManager = EMFUtil.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(User.builder().firstName("Vaibhav").lastName("Shukla").build());
        entityManager.persist(User.builder().firstName("John").lastName("Doe").build());
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = EMFUtil.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User" , User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        EMFUtil.close();
        log.info(" Users : {} " , users);


    }
}
