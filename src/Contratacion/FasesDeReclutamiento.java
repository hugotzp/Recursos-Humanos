/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author Edwin Chocoy
 */

@Entity
@NamedQuery(name="obtenerFasesDeReclutamiento",query="SELECT f FROM FasesDeReclutamiento f WHERE f.idReclutamiento = :id")
public class FasesDeReclutamiento implements Serializable {
    @TableGenerator(
            name="secuenciaFaseDeReclutamiento",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaFaseDeReclutamiento")
    @Column(name="idFasesDeReclutamiento")
    private Long id;

    private static final long serialVersionUID = 1L;
    
    @Column(name="Reclutamiento_idReclutamiento")
    private Long idReclutamiento;
     @Column(name="FaseReclutamiento_idFaseReclutamiento")
    private Long idFaseReclutamiento;
     
    @Transient
    private String nombre;

    public Long getIdReclutamiento() {
        return idReclutamiento;
    }

    public Long getIdFaseReclutamiento() {
        return idFaseReclutamiento;
    }

    public void setIdReclutamiento(Long idReclutamiento) {
        this.idReclutamiento = idReclutamiento;
    }

    public void setIdFaseReclutamiento(Long idFaseReclutamiento) {
        this.idFaseReclutamiento = idFaseReclutamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclutamiento != null ? idReclutamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FasesDeReclutamiento)) {
            return false;
        }
        FasesDeReclutamiento other = (FasesDeReclutamiento) object;
        if ((this.idReclutamiento == null && other.idReclutamiento != null) || (this.idReclutamiento != null && !this.idReclutamiento.equals(other.idReclutamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contratacion.FasesDeReclutamiento[ id=" + idReclutamiento + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void obtenerNombre(){
        JpaControllerFaseReclutamiento p = new JpaControllerFaseReclutamiento(Conexion.Conexion.getConexion().getEMF());
        FaseReclutamiento f = p.findFaseReclutamiento(idFaseReclutamiento);
        this.nombre = f.getNombre();
    }
    
}
