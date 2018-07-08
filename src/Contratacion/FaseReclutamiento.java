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
import javax.persistence.TableGenerator;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
public class FaseReclutamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaFaseReclutamiento",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaPropuesta")
    @Column(name="idFaseReclutamiento")
    private Long id;
    private String Nombre;
        
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaseReclutamiento)) {
            return false;
        }
        FaseReclutamiento other = (FaseReclutamiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contratacion.FaseReclutamiento[ id=" + id + " ]";
    }
    
}
