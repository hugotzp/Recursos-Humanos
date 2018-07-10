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
public interface ModuloContratacion {
    
    public void obtenerReclutamientos();
    
    public void guardarReclutamiento(Reclutar reclutamiento);
    
    public void contratarEmpleado();
    
    public void crearFaseReclutamiento(String nombre);
    
    public void obtenerFasesReclutamientoExistentes();
    
}
