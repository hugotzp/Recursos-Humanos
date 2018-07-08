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
public class JpaControllerFase implements Serializable {

    public JpaControllerFase(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CalificacionesAspirantes fase) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fase);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFase(fase.getId()) != null) {
                throw new PreexistingEntityException("Fase " + fase + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CalificacionesAspirantes fase) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            fase = em.merge(fase);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = fase.getId();
                if (findFase(id) == null) {
                    throw new NonexistentEntityException("The fase with id " + id + " no longer exists.");
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
            CalificacionesAspirantes fase;
            try {
                fase = em.getReference(CalificacionesAspirantes.class, id);
                fase.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fase with id " + id + " no longer exists.", enfe);
            }
            em.remove(fase);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CalificacionesAspirantes> findFaseEntities() {
        return findFaseEntities(true, -1, -1);
    }

    public List<CalificacionesAspirantes> findFaseEntities(int maxResults, int firstResult) {
        return findFaseEntities(false, maxResults, firstResult);
    }

    private List<CalificacionesAspirantes> findFaseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CalificacionesAspirantes.class));
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

    public CalificacionesAspirantes findFase(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CalificacionesAspirantes.class, id);
        } finally {
            em.close();
        }
    }

    public int getFaseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CalificacionesAspirantes> rt = cq.from(CalificacionesAspirantes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
