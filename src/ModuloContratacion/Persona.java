/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloContratacion;

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
    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido);
    /**
     *
     * @param dpi
     */
    public void setDPI(String dpi);
    /**
     *
     * @param genero
     */
    public void setGenero(Boolean genero);
    /**
     *
     * @param fecha
     */
    public void setFechaNacimiento(Date fecha);
    /**
     *
     * @param telefono
     */
    public void setNumeroTelefonico(String telefono);
    
    public void getNombre();
    
    public void getApellido();
    
    public void getDPI();
    
    public void getGenero();
    
    public void getFechaNacimiento();
    
    public void getNumeroTelefonico();
    
    public int calcularEdad();
}
