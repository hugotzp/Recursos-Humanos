/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Contratacion.exceptions.NonexistentEntityException;
import Contratacion.exceptions.PreexistingEntityException;
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
 * @author Hugo
 */
public class JpaControllerCalificacionesAspirante implements Serializable {

    public JpaControllerCalificacionesAspirante(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CalificacionesAspirante calificacionesAspirante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(calificacionesAspirante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalificacionesAspirante(calificacionesAspirante.getId()) != null) {
                throw new PreexistingEntityException("CalificacionesAspirante " + calificacionesAspirante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CalificacionesAspirante calificacionesAspirante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            calificacionesAspirante = em.merge(calificacionesAspirante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = calificacionesAspirante.getId();
                if (findCalificacionesAspirante(id) == null) {
                    throw new NonexistentEntityException("The calificacionesAspirante with id " + id + " no longer exists.");
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
            CalificacionesAspirante calificacionesAspirante;
            try {
                calificacionesAspirante = em.getReference(CalificacionesAspirante.class, id);
                calificacionesAspirante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calificacionesAspirante with id " + id + " no longer exists.", enfe);
            }
            em.remove(calificacionesAspirante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CalificacionesAspirante> findCalificacionesAspiranteEntities() {
        return findCalificacionesAspiranteEntities(true, -1, -1);
    }

    public List<CalificacionesAspirante> findCalificacionesAspiranteEntities(int maxResults, int firstResult) {
        return findCalificacionesAspiranteEntities(false, maxResults, firstResult);
    }

    private List<CalificacionesAspirante> findCalificacionesAspiranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CalificacionesAspirante.class));
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

    public CalificacionesAspirante findCalificacionesAspirante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CalificacionesAspirante.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalificacionesAspiranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CalificacionesAspirante> rt = cq.from(CalificacionesAspirante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    ArrayList<CalificacionesAspirante> ObtenerFasesAspirante(Long idPersona) {
        EntityManager em = getEntityManager();
        TypedQuery<CalificacionesAspirante> query = em.createNamedQuery("obtenerCalificaciones",CalificacionesAspirante.class);
        query.setParameter("idAspirante", idPersona);
        return new ArrayList(query.getResultList());
    }
    
}
