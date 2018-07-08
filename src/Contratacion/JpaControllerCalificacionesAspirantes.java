/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Conexion.exceptions.NonexistentEntityException;
import Conexion.exceptions.PreexistingEntityException;
import Contratacion.CalificacionesAspirantes;
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
public class JpaControllerCalificacionesAspirantes implements Serializable {

    public JpaControllerCalificacionesAspirantes(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CalificacionesAspirantes calificacionesAspirantes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calificacionesAspirantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalificacionesAspirantes(calificacionesAspirantes.getId()) != null) {
                throw new PreexistingEntityException("CalificacionesAspirantes " + calificacionesAspirantes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CalificacionesAspirantes calificacionesAspirantes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            calificacionesAspirantes = em.merge(calificacionesAspirantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = calificacionesAspirantes.getId();
                if (findCalificacionesAspirantes(id) == null) {
                    throw new NonexistentEntityException("The calificacionesAspirantes with id " + id + " no longer exists.");
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
            CalificacionesAspirantes calificacionesAspirantes;
            try {
                calificacionesAspirantes = em.getReference(CalificacionesAspirantes.class, id);
                calificacionesAspirantes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacionesAspirantes with id " + id + " no longer exists.", enfe);
            }
            em.remove(calificacionesAspirantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CalificacionesAspirantes> findCalificacionesAspirantesEntities() {
        return findCalificacionesAspirantesEntities(true, -1, -1);
    }

    public List<CalificacionesAspirantes> findCalificacionesAspirantesEntities(int maxResults, int firstResult) {
        return findCalificacionesAspirantesEntities(false, maxResults, firstResult);
    }

    private List<CalificacionesAspirantes> findCalificacionesAspirantesEntities(boolean all, int maxResults, int firstResult) {
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

    public CalificacionesAspirantes findCalificacionesAspirantes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CalificacionesAspirantes.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalificacionesAspirantesCount() {
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
    
    public ArrayList ObtenerFasesAspirante(Long idAspirante){
        EntityManager em = getEntityManager();
        TypedQuery<CalificacionesAspirantes> query = em.createNamedQuery("obtenerCalificaciones",CalificacionesAspirantes.class);
        query.setParameter("id", idAspirante);
        return (ArrayList) query.getResultList();
    }
    
}
