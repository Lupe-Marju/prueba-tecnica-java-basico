package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;

import java.util.List;

public class ClienteJPA {
    public void agregar(Cliente cliente) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }
}
    public List<Cliente> listar() {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        }
    }

    public Cliente buscar(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Cliente cliente = em.find(Cliente.class, id);
            return cliente;
        }
    }

    public void actualizar(Cliente cliente) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        }
    }

    public boolean eliminar(Long id) {
        try (EntityManager em = ConfigJPA.getEntityManager()) {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
    }


        }
