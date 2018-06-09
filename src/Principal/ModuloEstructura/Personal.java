/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.ModuloEstructura;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Chocoy
 */
public class Personal implements Persona{
    
    public String Nombre;
    public String Apellido;
    public String DPI;
    public boolean Genero;
    public Date fechaNaciemiento;
    public String Telefono;

    @Override
    public void setNombre(String nombre) {
        this.Nombre=nombre;
    }

    @Override
    public String getNombre() {
        return this.Nombre;
        
    }

    @Override
    public void setApellido(String apellido) {
        this.Apellido=apellido;
    }

    @Override
    public String getApellido() {
        return this.Apellido;
        
    }

    @Override
    public void setDPI(String dpi) {
        this.DPI=dpi;
    }

    @Override
    public String getDPI() {
        return this.DPI;
        
    }

    @Override
    public void setGenero(boolean genero) {
        this.Genero=genero;
    }

    @Override
    public boolean getGenero() {
        return this.Genero;
        
    }

    @Override
    public void setFechaNacimiento(Date fecha) {
        this.fechaNaciemiento=fecha;
    }

    @Override
    public Date getFechaNacimiento() {
        return this.fechaNaciemiento;
        
    }

    @Override
    public void setNumeroTelefonico(String telefono) {
        this.Telefono=telefono;
    }

    @Override
    public String getNumeroTelefonico() {
        return this.Telefono;
        
    }

    @Override
    public int calcularEdad() {
        
        int edad = 0;
        /*String fecha="08-09-1998";
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNacimiento= format.parse(fecha);*/
        Date fechaNacimiento = this.fechaNaciemiento;
        Date fechaActual= new Date();
        edad = fechaActual.getYear()-fechaNacimiento.getYear();
        return edad;
        
    }
        
    

    
}
