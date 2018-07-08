/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Contratacion.exceptions.NonexistentEntityException;
import Estructura.Departamentos;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Edwin Chocoy
 */
public class JpaControllerFasesDeReclutamiento implements Serializable {

    public JpaControllerFasesDeReclutamiento(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FasesDeReclutamiento fasesDeReclutamiento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fasesDeReclutamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FasesDeReclutamiento fasesDeReclutamiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            fasesDeReclutamiento = em.merge(fasesDeReclutamiento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = fasesDeReclutamiento.getIdReclutamiento();
                if (findFasesDeReclutamiento(id) == null) {
                    throw new NonexistentEntityException("The fasesDeReclutamiento with id " + id + " no longer exists.");
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
            FasesDeReclutamiento fasesDeReclutamiento;
            try {
                fasesDeReclutamiento = em.getReference(FasesDeReclutamiento.class, id);
                fasesDeReclutamiento.getIdReclutamiento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fasesDeReclutamiento with id " + id + " no longer exists.", enfe);
            }
            em.remove(fasesDeReclutamiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FasesDeReclutamiento> findFasesDeReclutamientoEntities() {
        return findFasesDeReclutamientoEntities(true, -1, -1);
    }

    public List<FasesDeReclutamiento> findFasesDeReclutamientoEntities(int maxResults, int firstResult) {
        return findFasesDeReclutamientoEntities(false, maxResults, firstResult);
    }

    private List<FasesDeReclutamiento> findFasesDeReclutamientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FasesDeReclutamiento.class));
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

    public FasesDeReclutamiento findFasesDeReclutamiento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FasesDeReclutamiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getFasesDeReclutamientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FasesDeReclutamiento> rt = cq.from(FasesDeReclutamiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public ArrayList obtenerFasesDeReclutamiento(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<FasesDeReclutamiento> query = em.createNamedQuery("obtenerFasesDeReclutamiento",FasesDeReclutamiento.class);
        query.setParameter("id", id);
        List<FasesDeReclutamiento> fases = query.getResultList();

        return (ArrayList) fases;

    }
    
}
