/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuraOrganizacional;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public class Departamentos implements AreaDeTrabajo {
    
    public String Nombre;
    public ArrayList Pesonal;
    
    
    @Override
    public void setPersonal(Empleo trabajador) {
        
    }
    
    @Override
    public ArrayList getPersonal() {
        return null;
    }
    @Override
    public void setNombre(String nombre) {
        this.Nombre=nombre;
        
    }

    @Override
    public String getNombre() {
        return this.Nombre;
        
    }
    
}
