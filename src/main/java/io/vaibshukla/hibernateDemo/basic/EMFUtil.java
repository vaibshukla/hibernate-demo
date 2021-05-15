package io.vaibshukla.hibernateDemo.basic;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class EMFUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManager() {
        if (entityManagerFactory == null ) {
            synchronized (EMFUtil.class) {
                if (entityManagerFactory == null) {

                    entityManagerFactory = Persistence.createEntityManagerFactory("jpaBaseConfiguration");
                }
            }
        }
        return entityManagerFactory;
    }

    public static void close() {
        if (entityManagerFactory != null ) {
            synchronized (EMFUtil.class) {
                if (entityManagerFactory != null) {

                    entityManagerFactory.close();
                }
            }
        }
    }
}
