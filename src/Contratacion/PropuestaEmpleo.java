
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Propuesta")
public class PropuestaEmpleo implements Puesto,Serializable{
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaPropuesta",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaPropuesta")
    @Column(name="idPropuesta")
    private Long id;
    @Column(name="Empleo_idEmpleo")
    private Long idEmpleo;
    @Column(name="Departamento_idDepartamento")
    private Long idDepartamento;
    
    public String Descripcion;
    public String Requisitos;
    public float Salario;
    
    public String Puesto;
    
    
    
    
    @Override
    public void setNombre(String nombre) {
        this.Puesto=nombre;
    }

    @Override
    public String getNombre() {
        return Puesto;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.Descripcion=descripcion;
    }

    @Override
    public String getDescripcion() {
        return Descripcion;   
    }

    @Override
    public void setSalario(float valor) {
        this.Salario=valor;

    }

    @Override
    public float getSalario() {
        return Salario;        
    }

    @Override
    public void setRequisitos(String requisito) {
        this.Requisitos=requisito;
    }

    @Override
    public String getRequisitos() {
        return Requisitos;
    }

    //BD
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setIdEmpleo(Long idEmpleo) {
        this.idEmpleo = idEmpleo;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public Long getId() {
        return id;
    }

    public Long getIdEmpleo() {
        return idEmpleo;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }
    
    
    
}
