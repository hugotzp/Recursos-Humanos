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
 * @author Edwin Chocoy
 */
public class JpaControllerAspirantes implements Serializable {

    public JpaControllerAspirantes(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aspirantes aspirantes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aspirantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAspirantes(aspirantes.getId()) != null) {
                throw new PreexistingEntityException("Aspirantes " + aspirantes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aspirantes aspirantes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aspirantes = em.merge(aspirantes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = aspirantes.getId();
                if (findAspirantes(id) == null) {
                    throw new NonexistentEntityException("The aspirantes with id " + id + " no longer exists.");
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
            Aspirantes aspirantes;
            try {
                aspirantes = em.getReference(Aspirantes.class, id);
                aspirantes.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aspirantes with id " + id + " no longer exists.", enfe);
            }
            em.remove(aspirantes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aspirantes> findAspirantesEntities() {
        return findAspirantesEntities(true, -1, -1);
    }

    public List<Aspirantes> findAspirantesEntities(int maxResults, int firstResult) {
        return findAspirantesEntities(false, maxResults, firstResult);
    }

    private List<Aspirantes> findAspirantesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aspirantes.class));
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

    public Aspirantes findAspirantes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aspirantes.class, id);
        } finally {
            em.close();
        }
    }

    public int getAspirantesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aspirantes> rt = cq.from(Aspirantes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public ArrayList getAspirantesReclutamiento(Long idReclutamiento){
        EntityManager em = getEntityManager();
        TypedQuery<Aspirantes> query = em.createNamedQuery("buscarAspirantesReclutamiento",Aspirantes.class);
        query.setParameter("id", idReclutamiento);
        return new ArrayList(query.getResultList());
    }
    
}
