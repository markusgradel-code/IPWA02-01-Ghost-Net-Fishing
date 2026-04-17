package dao;

import model.GhostNet;
import javax.persistence.*;
import java.util.List;

public class GhostNetDAO {
    // Einmaliges Erstellen der EntityManagerFactory, damit wir sie überall nutzen können
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostNetPU");

    public void save(GhostNet net) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (net.getId() == 0) {
                System.out.println("DAO: persist (neu)");
                em.persist(net); 
            } else {
                System.out.println("DAO: merge (update)");
                em.merge(net); }       
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close(); }
    }

    public List<GhostNet> findAll() {
        EntityManager em = emf.createEntityManager();
        // SELECT-Abfrage, um alle Geisternetze zu holen
        Query query = em.createQuery("SELECT g FROM GhostNet g");
        List<GhostNet> results = query.getResultList();
        em.close();
        return results;
    }
}