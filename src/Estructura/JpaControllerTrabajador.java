/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Estructura.exceptions.NonexistentEntityException;
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
 * @author Edwin Chocoy
 */
public class JpaControllerTrabajador implements Serializable, ContratacionEmpleados, AdministradorTrabajador  {

    public JpaControllerTrabajador(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Trabajador trabajador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(trabajador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trabajador trabajador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            trabajador = em.merge(trabajador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = trabajador.getId();
                if (findTrabajador(id) == null) {
                    throw new NonexistentEntityException("The trabajador with id " + id + " no longer exists.");
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
            Trabajador trabajador;
            try {
                trabajador = em.getReference(Trabajador.class, id);
                trabajador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trabajador with id " + id + " no longer exists.", enfe);
            }
            em.remove(trabajador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Trabajador> findTrabajadorEntities() {
        return findTrabajadorEntities(true, -1, -1);
    }

    public List<Trabajador> findTrabajadorEntities(int maxResults, int firstResult) {
        return findTrabajadorEntities(false, maxResults, firstResult);
    }

    private List<Trabajador> findTrabajadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trabajador.class));
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

    public Trabajador findTrabajador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Trabajador.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrabajadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trabajador> rt = cq.from(Trabajador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Trabajador> obtenerTDepartamentos(Long idDepa){
        EntityManager em = getEntityManager();
        TypedQuery<Trabajador> query = em.createNamedQuery("obtenerTrabajadoresDerpartamento",Trabajador.class);
        return query.setParameter("idDepa", idDepa).getResultList();
    }

    @Override
    public void contratarEmpleado(Long idPersona, Long idEmpleado, Long idDepartamento, float salarioBase) {
        Trabajador t = new Trabajador();
        t.setIdPersona(idPersona);
        t.setIdEmpleo(idEmpleado);
        t.setIdDepartamento(idDepartamento);
        t.setSalario(salarioBase);
        
        create(t);
    }

    @Override
    public Trabajador getTrabajador(Long id) {
        return findTrabajador(id);
    }
    
}
