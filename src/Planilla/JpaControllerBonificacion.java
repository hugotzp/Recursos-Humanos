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
public class JpaControllerBonificacion implements Serializable {

    public JpaControllerBonificacion(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Bonificacion> findBonificaciones(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<Bonificacion> query = em.createNamedQuery("BonificacionesTrabajador",Bonificacion.class);
        return query.setParameter("idPago",id).getResultList();
    }
    
    public void create(Bonificacion bonificacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bonificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bonificacion bonificacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bonificacion = em.merge(bonificacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bonificacion.getId();
                if (findBonificacion(id) == null) {
                    throw new NonexistentEntityException("The bonificacion with id " + id + " no longer exists.");
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
            Bonificacion bonificacion;
            try {
                bonificacion = em.getReference(Bonificacion.class, id);
                bonificacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bonificacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(bonificacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bonificacion> findBonificacionEntities() {
        return findBonificacionEntities(true, -1, -1);
    }

    public List<Bonificacion> findBonificacionEntities(int maxResults, int firstResult) {
        return findBonificacionEntities(false, maxResults, firstResult);
    }

    private List<Bonificacion> findBonificacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bonificacion.class));
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

    public Bonificacion findBonificacion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bonificacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getBonificacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bonificacion> rt = cq.from(Bonificacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
