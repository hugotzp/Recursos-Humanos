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
public class JpaControllerNotaDebito implements Serializable {

    public JpaControllerNotaDebito(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public NotaDebito findFormaPago(Long id){
        EntityManager em = getEntityManager();
        TypedQuery<NotaDebito> query = em.createNamedQuery("NotaDebitoTrabajador",NotaDebito.class);
        List<NotaDebito> lista = query.setParameter("idPago",id).getResultList();
        return lista.get(lista.size()-1);
    }

    public void create(NotaDebito notaDebito) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notaDebito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotaDebito notaDebito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notaDebito = em.merge(notaDebito);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notaDebito.getId();
                if (findNotaDebito(id) == null) {
                    throw new NonexistentEntityException("The notaDebito with id " + id + " no longer exists.");
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
            NotaDebito notaDebito;
            try {
                notaDebito = em.getReference(NotaDebito.class, id);
                notaDebito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notaDebito with id " + id + " no longer exists.", enfe);
            }
            em.remove(notaDebito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotaDebito> findNotaDebitoEntities() {
        return findNotaDebitoEntities(true, -1, -1);
    }

    public List<NotaDebito> findNotaDebitoEntities(int maxResults, int firstResult) {
        return findNotaDebitoEntities(false, maxResults, firstResult);
    }

    private List<NotaDebito> findNotaDebitoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NotaDebito.class));
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

    public NotaDebito findNotaDebito(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotaDebito.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotaDebitoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NotaDebito> rt = cq.from(NotaDebito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
