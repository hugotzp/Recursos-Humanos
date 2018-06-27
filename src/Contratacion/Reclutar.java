
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contratacion;


import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Edwin Chocoy
 */
public class Reclutar implements Reclutamiento{
    
    public Date fechaContratacion;
    public Date fechaInicio;
    public Date fechaFin;
    public String Departamento;

    public ArrayList numeroFases;
    
    public PersonasInteresadas aspirante;
    public PropuestaEmpleo propuesta = new PropuestaEmpleo();

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public void setNumeroFases(ArrayList numeroFases) {
        this.numeroFases = numeroFases;
    }

    public void setAspirante(PersonasInteresadas aspirante) {
        this.aspirante = aspirante;
    }

    public void setPropuesta(PropuestaEmpleo propuesta) {
        this.propuesta = propuesta;
    }

    
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public ArrayList getNumeroFases() {
        return numeroFases;
    }

    public PersonasInteresadas getAspirante() {
        return aspirante;
    }

    public PropuestaEmpleo getPropuesta() {
        return propuesta;
    }

    @Override
    public void compararAspirantes() {
        
    }

    @Override
    public void preseleccionarFinalistas() {
        
    }

    @Override
    public void contratar() {
        
    }
    

    @Override
    
    public void setFaseReclutamiento(int numero){
        this.numeroFases.add(numero);
    }
    

}
