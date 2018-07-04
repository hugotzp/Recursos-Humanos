
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import Estructura.Persona;
import Estructura.Personal;
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
public class Aspirantes implements PersonasInteresadas,ColeccionIteradores,Serializable{
    
    public ArrayList<FaseReclutamiento> fases;
    public static Persona persona;
    
    
    
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaAspirante",
            allocationSize = 1,
            initialValue= 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaAspirante")
    @Id
    private Long id;
    @Column(name="enProceso")
    public boolean enProceso;
    @Column(name="SalarioEsperado")
    public float salarioEsperado;
    
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
    public void setTipoProceso(boolean tipo) {

        this.enProceso=tipo;
        
    }

    @Override
    public boolean getTipoProceso() {

        return enProceso;
        
    }

    @Override
    public void setFasesReclutamiento(FaseReclutamiento fase) {

        this.fases.add(fase);

    }

    @Override
    public ArrayList getFasesReclutamiento() {
        return fases;  
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorFases(this);
    }

    @Override
    public void cargarFaseReclutamiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
