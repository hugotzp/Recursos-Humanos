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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Hugo
 */
public class JpaControllerPlanilla implements Serializable {

    public JpaControllerPlanilla(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PlanillaDepartamento planillaDepartamento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(planillaDepartamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PlanillaDepartamento planillaDepartamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            planillaDepartamento = em.merge(planillaDepartamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = planillaDepartamento.getId();
                if (findPlanillaDepartamento(id) == null) {
                    throw new NonexistentEntityException("The planillaDepartamento with id " + id + " no longer exists.");
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
            PlanillaDepartamento planillaDepartamento;
            try {
                planillaDepartamento = em.getReference(PlanillaDepartamento.class, id);
                planillaDepartamento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The planillaDepartamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(planillaDepartamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PlanillaDepartamento> findPlanillaDepartamentoEntities() {
        return findPlanillaDepartamentoEntities(true, -1, -1);
    }

    public List<PlanillaDepartamento> findPlanillaDepartamentoEntities(int maxResults, int firstResult) {
        return findPlanillaDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<PlanillaDepartamento> findPlanillaDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PlanillaDepartamento.class));
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

    public PlanillaDepartamento findPlanillaDepartamento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PlanillaDepartamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlanillaDepartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PlanillaDepartamento> rt = cq.from(PlanillaDepartamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
