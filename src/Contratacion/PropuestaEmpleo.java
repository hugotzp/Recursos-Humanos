
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Estructura.AdaptadorContratarEmpleado;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Propuesta")
public class PropuestaEmpleo implements Serializable,Puesto{
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
    
    @Column(name="Descripcion")
    public String Descripcion;
    @Column(name="Requisitos")
    public String Requisitos;
    @Column(name="SalarioPropuesto")
    public float Salario;
        
    @Transient
    public String NombreEmpleo;
    
    @Transient
    private String Departamento;

    public String getDepartamento() {
        return Departamento;
    } 
    
    public PropuestaEmpleo(){
        this.id = 0L;
        this.idEmpleo = 0L;
        this.idDepartamento = 0L;
        this.Descripcion = "";
        this.Requisitos = "";
        this.Salario = (float)0;
    }
    
    


    public String getPuesto() {
        return NombreEmpleo;
    }

    public void setPuesto(String Puesto) {
        this.NombreEmpleo = Puesto;
    }
    
    @Override
    public void setNombre(String nombre) {
        this.NombreEmpleo=nombre;
    }

    @Override
    public String getNombre() {
        return NombreEmpleo;
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
    
    public void obtenerNombre(){
        AdaptadorDepartamentos a = new AdaptadorDepartamentos();
        this.Departamento = a.getDepartamento(idDepartamento).getNombre();
        AdaptadorContratarEmpleado c = new AdaptadorContratarEmpleado();
        this.NombreEmpleo = c.getEmpleo(idEmpleo);
    }
}
