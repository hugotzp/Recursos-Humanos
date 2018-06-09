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
public class Trabajador implements Empleo {
    
    public String Nombre;
    public float Salario;
    public Persona Persona;
    
    
    
    @Override
    public void setSalario(float salario) {
        this.Salario=salario;
        
    }

    @Override
    public void setNombre(String nombre) {
        this.Nombre=nombre;
        
    }

    @Override
    public void setPersona(Persona persona) {
        this.Persona=persona;
        
    }

    @Override
    public float getSalario() {
        return this.Salario;
        
    }

    @Override
    public String getNombre() {
        return this.Nombre;
        
    }

    @Override
    public Persona getPersona() {
        return this.Persona;
        
    }

    @Override
    public ArrayList obtenerInformacion() {
        
        ArrayList informacion = null;
        
        return informacion;
        
    }
    
}
