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
public class Contratacion implements ModuloContratacion {
   
    JpaControllerReclutar jpaReclutar;
    
    public void Contratacion(JpaControllerReclutar jpa){
        this.jpaReclutar=jpa;
    }
    
    
    
    
    @Override
    public ArrayList obtenerReclutamientos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarReclutamiento(Reclutar reclutamiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contratarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
