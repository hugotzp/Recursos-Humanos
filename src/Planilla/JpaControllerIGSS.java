/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Planilla.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hugo
 */
public class JpaControllerIGSS implements Serializable {

    public JpaControllerIGSS(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

     public List<IGSS> findIGSSTrabajador(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<IGSS> query = em.createNamedQuery("IGSSTrabajador",IGSS.class);
        return query.setParameter("idPago",id).getResultList();
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IGSS IGSS) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(IGSS);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IGSS IGSS) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IGSS = em.merge(IGSS);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = IGSS.getId();
                if (findIGSS(id) == null) {
                    throw new NonexistentEntityException("The iGSS with id " + id + " no longer exists.");
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
            IGSS IGSS;
            try {
                IGSS = em.getReference(IGSS.class, id);
                IGSS.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The IGSS with id " + id + " no longer exists.", enfe);
            }
            em.remove(IGSS);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IGSS> findIGSSEntities() {
        return findIGSSEntities(true, -1, -1);
    }

    public List<IGSS> findIGSSEntities(int maxResults, int firstResult) {
        return findIGSSEntities(false, maxResults, firstResult);
    }

    private List<IGSS> findIGSSEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IGSS.class));
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

    public IGSS findIGSS(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IGSS.class, id);
        } finally {
            em.close();
        }
    }

    public int getIGSSCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IGSS> rt = cq.from(IGSS.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
