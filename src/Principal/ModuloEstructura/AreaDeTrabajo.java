/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.ModuloEstructura;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface AreaDeTrabajo {
    
    /**
     *
     * @param trabajador
     */
    public void setPersonal(Empleo trabajador);
    
    public ArrayList getPersonal();
    
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre);
    
    public String getNombre();
    
}
