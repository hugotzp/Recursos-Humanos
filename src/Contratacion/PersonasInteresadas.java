
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contratacion;


import Personas.*;
import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface PersonasInteresadas {
    
    public void setPersona(Persona persona);
    
    public void setTipoProceso(boolean tipo);
    
    public void setFasesReclutamiento(Calificacion fase);
    
    public boolean getTipoProceso();

    public ArrayList getFasesReclutamiento();
    
    public void cargarFaseReclutamiento();
    
    public void cargarPersona();
    
    
}
