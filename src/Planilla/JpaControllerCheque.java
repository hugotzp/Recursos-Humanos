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
public class JpaControllerCheque implements Serializable {

    public JpaControllerCheque(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Cheque findFormaPago(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<Cheque> query = em.createNamedQuery("ChequeTrabajador",Cheque.class);
        return query.setParameter("idPago",id).getResultList().get(0);
    }

    public void create(Cheque cheque) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cheque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cheque cheque) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cheque = em.merge(cheque);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cheque.getId();
                if (findCheque(id) == null) {
                    throw new NonexistentEntityException("The cheque with id " + id + " no longer exists.");
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
            Cheque cheque;
            try {
                cheque = em.getReference(Cheque.class, id);
                cheque.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cheque with id " + id + " no longer exists.", enfe);
            }
            em.remove(cheque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cheque> findChequeEntities() {
        return findChequeEntities(true, -1, -1);
    }

    public List<Cheque> findChequeEntities(int maxResults, int firstResult) {
        return findChequeEntities(false, maxResults, firstResult);
    }

    private List<Cheque> findChequeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cheque.class));
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

    public Cheque findCheque(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cheque.class, id);
        } finally {
            em.close();
        }
    }

    public int getChequeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cheque> rt = cq.from(Cheque.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
