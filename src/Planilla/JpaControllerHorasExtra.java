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
public class JpaControllerHorasExtra implements Serializable {

    public JpaControllerHorasExtra(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public List<HorasExtra> findHorasExtraTrabajador(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<HorasExtra> query = em.createNamedQuery("HorasExtraTrabajador",HorasExtra.class);
        return query.setParameter("idPago",id).getResultList();
    }

    public void create(HorasExtra horasExtra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(horasExtra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HorasExtra horasExtra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            horasExtra = em.merge(horasExtra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = horasExtra.getId();
                if (findHorasExtra(id) == null) {
                    throw new NonexistentEntityException("The horasExtra with id " + id + " no longer exists.");
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
            HorasExtra horasExtra;
            try {
                horasExtra = em.getReference(HorasExtra.class, id);
                horasExtra.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The horasExtra with id " + id + " no longer exists.", enfe);
            }
            em.remove(horasExtra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HorasExtra> findHorasExtraEntities() {
        return findHorasExtraEntities(true, -1, -1);
    }

    public List<HorasExtra> findHorasExtraEntities(int maxResults, int firstResult) {
        return findHorasExtraEntities(false, maxResults, firstResult);
    }

    private List<HorasExtra> findHorasExtraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HorasExtra.class));
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

    public HorasExtra findHorasExtra(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HorasExtra.class, id);
        } finally {
            em.close();
        }
    }

    public int getHorasExtraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HorasExtra> rt = cq.from(HorasExtra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
