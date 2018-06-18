/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Date;

/**
 *
 * @author Edwin Chocoy
 */
public interface Persona {
    
    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre);
    
    public String getNombre();
    
    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido);
    
    public String getApellido();
    
    /**
     *
     * @param dpi
     */
    public void setDPI(String dpi);
    
    public String getDPI();
    
    /**
     *
     * @param genero
     */
    public void setGenero(boolean genero);
    
    public boolean getGenero();
    
    /**
     *
     * @param fecha
     */
    public void setFechaNacimiento(Date fecha);
    
    public Date getFechaNacimiento();
    
    /**
     *
     * @param telefono
     */
    public void setNumeroTelefonico(String telefono);
    
    public String getNumeroTelefonico();
    
    public int calcularEdad();
}
