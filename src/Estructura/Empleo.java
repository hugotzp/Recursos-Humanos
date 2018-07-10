/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Edwin Chocoy
 */

@Entity
@Table(name="Empleo")
@NamedQuery(name="emExiste",query="SELECT d FROM Empleo d WHERE d.nombre = :nombre")
public class Empleo implements PuestoTrabajador,Serializable{
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaEmpleo",
            allocationSize = 1,
            initialValue= 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaEmpleo")
    @Column(name="idEmpleo")
    Long id;
    String nombre;

    @Override
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
