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
public class JpaControllerPago implements Serializable {

    public JpaControllerPago(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public List<PagoEmpleado> findPagosPlanilla(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<PagoEmpleado> query = em.createNamedQuery("pagosPlanilla",PagoEmpleado.class);
        return query.setParameter("idPlanilla",id).getResultList();
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PagoEmpleado pagoEmpleado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pagoEmpleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PagoEmpleado pagoEmpleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pagoEmpleado = em.merge(pagoEmpleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pagoEmpleado.getId();
                if (findPagoEmpleado(id) == null) {
                    throw new NonexistentEntityException("The pagoEmpleado with id " + id + " no longer exists.");
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
            PagoEmpleado pagoEmpleado;
            try {
                pagoEmpleado = em.getReference(PagoEmpleado.class, id);
                pagoEmpleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagoEmpleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(pagoEmpleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PagoEmpleado> findPagoEmpleadoEntities() {
        return findPagoEmpleadoEntities(true, -1, -1);
    }

    public List<PagoEmpleado> findPagoEmpleadoEntities(int maxResults, int firstResult) {
        return findPagoEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<PagoEmpleado> findPagoEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PagoEmpleado.class));
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

    public PagoEmpleado findPagoEmpleado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PagoEmpleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagoEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PagoEmpleado> rt = cq.from(PagoEmpleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
