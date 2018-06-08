/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloContratacion;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface Empleo {
    /**
     *
     * @param salario
     */
    public void setSalario(float salario);
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre);
    /**
     *
     * @param persona
     */
    public void setPersona(Persona persona);
    
    public void getSalario();
    
    public void getNombre();
    
    public Persona getPersona();
    
    public ArrayList obtenerInformacion();
  
}
