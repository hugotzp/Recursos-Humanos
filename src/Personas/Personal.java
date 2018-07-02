/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name="Persona")
public class Personal implements Serializable,Persona{
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaPersona",
            allocationSize = 1,
            initialValue= 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaPersona")
    @Column(name="idPersona")
    private Long id;
    private String Nombre;
    private String Apellido;
    private String DPI;
    private boolean Genero;
    @Temporal(TemporalType.DATE)
    private Date FechaNacimiento;
    private String Telefono;
    
    public Personal(){
        this.id = 0L;
        this.Nombre = "";
        this.Apellido = "";
        this.DPI = "";
        this.Genero = false;
        this.FechaNacimiento = new Date();
        this.Telefono = "";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isGenero() {
        return Genero;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personas.Personal[ id=" + id + " ]";
    }

    @Override
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    @Override
    public void setDPI(String dpi) {
        this.DPI = dpi;
    }

    @Override
    public void setGenero(boolean genero) {
        this.Genero = genero;
    }

    @Override
    public void setFechaNacimiento(Date fecha) {
        this.FechaNacimiento = fecha;
    }

    @Override
    public void setNumeroTelefonico(String telefono) {
        this.Telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public String getApellido() {
        return this.Apellido;
    }

    @Override
    public String getDPI() {
        return this.DPI;
    }

    @Override
    public boolean getGenero() {
        return this.Genero;
    }

    @Override
    public Date getFechaNacimiento() {
        return this.FechaNacimiento;
    }

    @Override
    public String getNumeroTelefonico() {
        return this.Telefono;
    }

    @Override
    public int calcularEdad() {
        int edad = 0;
        Date fechaActual= new Date();
        edad = fechaActual.getYear()-this.FechaNacimiento.getYear();
        return edad;
    }
    
}
