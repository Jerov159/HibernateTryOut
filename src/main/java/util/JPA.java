package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPA {

    private static final EntityManagerFactory entityManagerFactory=buildldEntityManagerFactory();

    private static EntityManagerFactory buildldEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemploJPA"); //Es singleton
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
