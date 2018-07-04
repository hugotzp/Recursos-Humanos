/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface AreaDeTrabajo {
    
    
    public void setPersonal(Trabajadores trabajador);
    
    public ArrayList getPersonal();    

    public void setNombre(String nombre);
    
    public String getNombre();
    
    public void obtenerEmpleados();
    
}
