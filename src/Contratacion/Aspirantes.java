
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import Personas.Persona;


/**
 *
 * @author Edwin Chocoy
 */
public class Aspirantes implements PersonasInteresadas{
    
    public boolean enProceso;
    public float salarioEsperado;

    public ArrayList<FaseReclutamiento> fases;
    public static Persona persona;

    public Aspirantes(Persona p) {
       this.persona = p;
    }

    public void setEnProceso(boolean enProceso) {
        this.enProceso = enProceso;
    }

    public void setSalarioEsperado(float salarioEsperado) {
        this.salarioEsperado = salarioEsperado;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
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
    
}
