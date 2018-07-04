/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Contratacion.exceptions.NonexistentEntityException;
import Contratacion.exceptions.PreexistingEntityException;
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
public class JpaControllerReclutar implements Serializable {

    public JpaControllerReclutar(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reclutar reclutar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reclutar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReclutar(reclutar.getId()) != null) {
                throw new PreexistingEntityException("Reclutar " + reclutar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reclutar reclutar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reclutar = em.merge(reclutar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclutar.getId();
                if (findReclutar(id) == null) {
                    throw new NonexistentEntityException("The reclutar with id " + id + " no longer exists.");
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
            Reclutar reclutar;
            try {
                reclutar = em.getReference(Reclutar.class, id);
                reclutar.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclutar with id " + id + " no longer exists.", enfe);
            }
            em.remove(reclutar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reclutar> findReclutarEntities() {
        return findReclutarEntities(true, -1, -1);
    }

    public List<Reclutar> findReclutarEntities(int maxResults, int firstResult) {
        return findReclutarEntities(false, maxResults, firstResult);
    }

    private List<Reclutar> findReclutarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reclutar.class));
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

    public Reclutar findReclutar(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reclutar.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclutarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reclutar> rt = cq.from(Reclutar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
