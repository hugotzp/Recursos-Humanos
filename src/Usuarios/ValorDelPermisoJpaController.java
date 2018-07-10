/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Usuarios.exceptions.NonexistentEntityException;
import Usuarios.exceptions.PreexistingEntityException;
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
public class ValorDelPermisoJpaController implements Serializable {

    public ValorDelPermisoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ValorDelPermiso valorDelPermiso) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(valorDelPermiso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findValorDelPermiso(valorDelPermiso.getIdPermiso()) != null) {
                throw new PreexistingEntityException("ValorDelPermiso " + valorDelPermiso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ValorDelPermiso valorDelPermiso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            valorDelPermiso = em.merge(valorDelPermiso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = valorDelPermiso.getIdPermiso();
                if (findValorDelPermiso(id) == null) {
                    throw new NonexistentEntityException("The valorDelPermiso with id " + id + " no longer exists.");
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
            ValorDelPermiso valorDelPermiso;
            try {
                valorDelPermiso = em.getReference(ValorDelPermiso.class, id);
                valorDelPermiso.getIdPermiso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The valorDelPermiso with id " + id + " no longer exists.", enfe);
            }
            em.remove(valorDelPermiso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ValorDelPermiso> findValorDelPermisoEntities() {
        return findValorDelPermisoEntities(true, -1, -1);
    }

    public List<ValorDelPermiso> findValorDelPermisoEntities(int maxResults, int firstResult) {
        return findValorDelPermisoEntities(false, maxResults, firstResult);
    }

    private List<ValorDelPermiso> findValorDelPermisoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ValorDelPermiso.class));
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

    public ValorDelPermiso findValorDelPermiso(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ValorDelPermiso.class, id);
        } finally {
            em.close();
        }
    }

    public int getValorDelPermisoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ValorDelPermiso> rt = cq.from(ValorDelPermiso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
