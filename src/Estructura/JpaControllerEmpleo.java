/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Estructura.exceptions.NonexistentEntityException;
import Estructura.exceptions.PreexistingEntityException;
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
public class JpaControllerEmpleo implements Serializable {

    public JpaControllerEmpleo(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleo empleo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpleo(empleo.getId()) != null) {
                throw new PreexistingEntityException("Empleo " + empleo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleo empleo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleo = em.merge(empleo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = empleo.getId();
                if (findEmpleo(id) == null) {
                    throw new NonexistentEntityException("The empleo with id " + id + " no longer exists.");
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
            Empleo empleo;
            try {
                empleo = em.getReference(Empleo.class, id);
                empleo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleo with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleo> findEmpleoEntities() {
        return findEmpleoEntities(true, -1, -1);
    }

    public List<Empleo> findEmpleoEntities(int maxResults, int firstResult) {
        return findEmpleoEntities(false, maxResults, firstResult);
    }

    private List<Empleo> findEmpleoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleo.class));
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

    public Empleo findEmpleo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleo> rt = cq.from(Empleo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
