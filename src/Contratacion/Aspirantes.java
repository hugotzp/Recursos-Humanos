
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conexion.Conexion;
import OtrasClases.*;
import Personas.*;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Aspirante")
public class Aspirantes implements PersonasInteresadas,IterableCollection,Serializable{
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaAspirante",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaAspirante")
    @Column(name="idAspirante")
    private Long id;
    @Column(name="enProceso")
    public boolean enProceso;
    @Column(name="SalarioEsperado")
    public float salarioEsperado;
    @Column(name="Persona_idPersona")
    private Long idPersona;
    @Column(name="Reclutamiento_idReclutamiento")
    private Long idReclutamiento;
    
    
    
    public ArrayList<Calificacion> fases;
    public Persona persona;
    
    public Aspirantes(Persona p) {
       this.persona = p;
    }

    public void setEnProceso(boolean enProceso) {
        this.enProceso = enProceso;
    }

    public void setSalarioEsperado(float salarioEsperado) {
        this.salarioEsperado = salarioEsperado;
    }

    public boolean getEnProceso() {
        return enProceso;
    }

    public float getSalarioEsperado() {
        return salarioEsperado;
    }

    public Persona getPersona() {
        return persona;
    }
    
    
    @Override
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    @Override
    public void setTipoProceso(boolean tipo) {
        this.enProceso=tipo;  
    }

    @Override
    public void setFasesReclutamiento(Calificacion fase) {
        this.fases.add(fase);
    }

    @Override
    public boolean getTipoProceso() {
        return enProceso;
    }
    
    @Override
    public ArrayList getFasesReclutamiento() {
        return fases;  
    }

    @Override
    public void cargarFaseReclutamiento() {
        Conexion c = Conexion.getConexion(); 
        JpaControllerCalificacionesAspirantes calificacion = new JpaControllerCalificacionesAspirantes(c.getEMF());
        fases=calificacion.ObtenerFasesAspirante(idPersona);
    }

    @Override
    public void cargarPersona() {
        ContratacionAdministradorPersona adaptador = new ContratacionAdministradorPersona();
        persona=adaptador.getPersona(idPersona);
        
    }
    
    @Override
    public Iterator crearIterador() {
        return new IteradorFases(this);
    }
    
    //BD
   
    public Long getId() {
        return id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public Long getIdReclutamiento() {
        return idReclutamiento;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdReclutamiento(Long idReclutamiento) {
        this.idReclutamiento = idReclutamiento;
    }

}