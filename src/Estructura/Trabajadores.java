/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Personas.*;
import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface Trabajadores {
    
    
    public void setSalario(float salario);
    
    public float getSalario();
       
    public void setPersona(Persona persona);

    public Persona getPersona();
    
    public Object obtenerInformacion(int tipo);
  
}
