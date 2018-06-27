
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.Hashtable;


/**
 *
 * @author Edwin Chocoy
 */

public class Fase implements FaseReclutamiento,MetodosConstructorFases{
    
    public int numeroFase;
    public String nombreFase;
    public Date fechaInicio;
    public Date fechaFin;
    public int desempeño;

    @Override
    public void setNumeroFase(int fase) {
        this.numeroFase=fase;
    }

    @Override
    public void setNombreFase(String nombre) {
        this.nombreFase=nombre;
    }

    @Override
    public void setPuntuacionDesempeño(int valor) {
        this.desempeño=valor;
    }

    @Override
    public void setFechaInicio(Date fecha) {
        this.fechaInicio=fecha;
    }

    @Override
    public void setFechaFin(Date fecha) {
        this.fechaFin=fecha;
    }

    @Override
    public int getNumeroFase() {
        return numeroFase;
    }

    @Override
    public String getNombreFase() {
        return nombreFase;
    }

    @Override
    public int getPuntuacionDesempeño() {
        return desempeño;
    }

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public Object getPropiedad(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPropiedades(Hashtable datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
