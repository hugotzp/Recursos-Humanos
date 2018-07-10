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
 * @author Hugo
 */
public class JpaControllerPropuestaEmpleo implements Serializable {

    public JpaControllerPropuestaEmpleo(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PropuestaEmpleo propuestaEmpleo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(propuestaEmpleo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PropuestaEmpleo propuestaEmpleo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            propuestaEmpleo = em.merge(propuestaEmpleo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = propuestaEmpleo.getId();
                if (findPropuestaEmpleo(id) == null) {
                    throw new NonexistentEntityException("The propuestaEmpleo with id " + id + " no longer exists.");
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
            PropuestaEmpleo propuestaEmpleo;
            try {
                propuestaEmpleo = em.getReference(PropuestaEmpleo.class, id);
                propuestaEmpleo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The propuestaEmpleo with id " + id + " no longer exists.", enfe);
            }
            em.remove(propuestaEmpleo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PropuestaEmpleo> findPropuestaEmpleoEntities() {
        return findPropuestaEmpleoEntities(true, -1, -1);
    }

    public List<PropuestaEmpleo> findPropuestaEmpleoEntities(int maxResults, int firstResult) {
        return findPropuestaEmpleoEntities(false, maxResults, firstResult);
    }

    private List<PropuestaEmpleo> findPropuestaEmpleoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PropuestaEmpleo.class));
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

    public PropuestaEmpleo findPropuestaEmpleo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PropuestaEmpleo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPropuestaEmpleoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PropuestaEmpleo> rt = cq.from(PropuestaEmpleo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
