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
public interface Empleo {
    
    /**
     *
     * @param salario
     */
    public void setSalario(float salario);
    
    public float getSalario();
    
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre);
    
    public String getNombre();
    
    /**
     *
     * @param persona
     */
    public void setPersona(Persona persona);

    public Persona getPersona();
    
    public ArrayList obtenerInformacion();
  
}
