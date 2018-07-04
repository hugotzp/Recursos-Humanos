/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Conexion.Conexion;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Departamento")

public class Departamentos implements AreaDeTrabajo, Serializable {
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaDepartamento",
            allocationSize = 1,
            initialValue= 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaDepartamento")
    @Column(name="idDepartamento")
    private Long id;
    public String Nombre;
    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    @Transient
    public ArrayList Personal;
    
    public void Departamentos(){
        this.id = 0L;
        this.Nombre = "";
    }
    

    @Override
    public void setPersonal(Trabajadores trabajador) {
        this.Personal.add(trabajador);
    }
    
    @Override
    public ArrayList getPersonal() {
        return Personal;
    }
    @Override
    public void setNombre(String nombre) {
        this.Nombre=nombre;
        
    }

    @Override
    public String getNombre() {
        return this.Nombre;
        
    }

    @Override
    public void obtenerEmpleados() {
        
        Conexion con = Conexion.getConexion();
        JpaControllerTrabajador t = new JpaControllerTrabajador(con.getEMF());
        Personal=new ArrayList(t.obtenerTDepartamentos(id));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamentos[ id=" + id + " ]";
    } 
    
}
