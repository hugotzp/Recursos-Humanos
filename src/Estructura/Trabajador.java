/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Conexion.Conexion;
import Personas.*;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="Trabajador")

@NamedQuery(name="obtenerTrabajadoresDerpartamento",query="SELECT t FROM Trabajador t WHERE t.idDepartamento = :idDepa")

public class Trabajador implements Trabajadores, Serializable {
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaTrabajador",
            allocationSize = 1,
            initialValue= 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaTrabajador")
    @Column(name="idTrabajador")
    private Long id;
    public float Salario;
    @Column(name="Persona_idPersona")
    private Long idPersona;
    @Column(name="Empleo_idEmpleo")
    private Long idEmpleo;
    @Column(name="Departamento_idDepartamento")
    private Long idDepartamento;
    
    
    @Transient
    public String NombreEmpleo;
    @Transient
    public Persona Persona;
    @Transient

    
    public void Trabajador(Persona p){
        
    }
    
    
    @Override
    public void setSalario(float salario) {
        this.Salario=salario;
        
    }

    @Override
    public void setPersona(Persona persona) {
        this.Persona=persona;
        
    }

    @Override
    public float getSalario() {
        return this.Salario;
        
    }

    @Override
    public Persona getPersona() {
            
        return Persona;
        
    }

    @Override
    public Object obtenerInformacion(int tipo) {
        
        Object informacion = null;
        
        return informacion;
        
    }
    
    @Override    
    public void obtenerPersona(){
        
        EstructuraAdministradorPersona adminPersona = new EstructuraAdministradorPersona();
        Persona=adminPersona.getPersona(idPersona.intValue());

    }    
    
    public void setNombreEmpleo(String NombreEmpleo) {
        this.NombreEmpleo = NombreEmpleo;
    }
        
    public String getNombreEmpleo() {
        return NombreEmpleo;
    }

    
    
    
    
    //BD
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdEmpleo(Long idEmpleo) {
        this.idEmpleo = idEmpleo;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    @Id
    public Long getId() {
        return id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public Long getIdEmpleo() {
        return idEmpleo;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
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
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajador [id="+id+"]";
    }    
    
}
