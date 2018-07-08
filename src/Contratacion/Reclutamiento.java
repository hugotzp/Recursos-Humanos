
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Contratacion;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface Reclutamiento {
    
    public void contratar();
    
    public void setFaseReclutamiento(int numero);    
    
    public void setEvaluacion(Evaluacion evaluacion);
  
    public void cargarAspirantes();
    
    public void cargarPuesto();
    
    public void cargarFases();
    
    public Object obtenerAspirantes();
    
    public Object obtenerFinalistas();   
}
