/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.util.Date;

/**
 *
 * @author Hugo
 */
public interface Persona {

    public void setNombre(String nombre);
    
    public void setApellido(String apellido);
    
    public void setDPI(String dpi);
    
    public void setGenero(boolean genero);
    
    public void setFechaNacimiento(Date fecha);
    
    public void setNumeroTelefonico(String telefono);
    
    public String getNombre();

    public String getApellido();

    public String getDPI();

    public boolean getGenero();

    public Date getFechaNacimiento();

    public String getNumeroTelefonico();
    
    public int calcularEdad();
}
