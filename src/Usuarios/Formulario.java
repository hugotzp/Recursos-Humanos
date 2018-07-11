/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@NamedQuery(name="formularioExiste",query="SELECT f FROM Formulario f WHERE f.nombre = :nombre")
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaFormulario",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaFormulario")
    @Column(name="idFormulario")
    private Long id;
    private String nombre;
    @Column(name="Paquete_idPaquete")
    private Long idPaquete;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getIdPaquete() {
        return idPaquete;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdPaquete(Long idPaquete) {
        this.idPaquete = idPaquete;
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
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuarios.Formulario[ id=" + id + " ]";
    }
    
}
