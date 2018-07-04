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
public class JpaControllerEfectivo implements Serializable {

    public JpaControllerEfectivo(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Efectivo findFormaPago(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<Efectivo> query = em.createNamedQuery("EfectivoTrabajador",Efectivo.class);
        return query.setParameter("idPago",id).getResultList().get(0);
    }

    public void create(Efectivo efectivo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(efectivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Efectivo efectivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            efectivo = em.merge(efectivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = efectivo.getId();
                if (findEfectivo(id) == null) {
                    throw new NonexistentEntityException("The efectivo with id " + id + " no longer exists.");
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
            Efectivo efectivo;
            try {
                efectivo = em.getReference(Efectivo.class, id);
                efectivo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The efectivo with id " + id + " no longer exists.", enfe);
            }
            em.remove(efectivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Efectivo> findEfectivoEntities() {
        return findEfectivoEntities(true, -1, -1);
    }

    public List<Efectivo> findEfectivoEntities(int maxResults, int firstResult) {
        return findEfectivoEntities(false, maxResults, firstResult);
    }

    private List<Efectivo> findEfectivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Efectivo.class));
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

    public Efectivo findEfectivo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Efectivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEfectivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Efectivo> rt = cq.from(Efectivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
