/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Contratacion.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Edwin Chocoy
 */
public class JpaControllerFaseReclutamiento implements Serializable {

    public JpaControllerFaseReclutamiento(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FaseReclutamiento faseReclutamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(faseReclutamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FaseReclutamiento faseReclutamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            faseReclutamiento = em.merge(faseReclutamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = faseReclutamiento.getId();
                if (findFaseReclutamiento(id) == null) {
                    throw new NonexistentEntityException("The faseReclutamiento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FaseReclutamiento faseReclutamiento;
            try {
                faseReclutamiento = em.getReference(FaseReclutamiento.class, id);
                faseReclutamiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The faseReclutamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(faseReclutamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FaseReclutamiento> findFaseReclutamientoEntities() {
        return findFaseReclutamientoEntities(true, -1, -1);
    }

    public List<FaseReclutamiento> findFaseReclutamientoEntities(int maxResults, int firstResult) {
        return findFaseReclutamientoEntities(false, maxResults, firstResult);
    }

    private List<FaseReclutamiento> findFaseReclutamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FaseReclutamiento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FaseReclutamiento findFaseReclutamiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FaseReclutamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getFaseReclutamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FaseReclutamiento> rt = cq.from(FaseReclutamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
