package org.example.persistence;

import jakarta.persistence.*;

public class ConfigJPA {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("unidadDePersistencia");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

}
