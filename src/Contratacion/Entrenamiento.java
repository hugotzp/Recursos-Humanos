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
public class Entrenamiento implements FaseReclutamiento,MetodosConstructorFases {
    
    public Date fechaInicio;
    public Date fechaFin;
    public int desempeño;
    public int puntuacionMaxima;
    public int numeroFase;
    public String nombreFase;

    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDesempeño(int desempeño) {
        this.desempeño = desempeño;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public int getDesempeño() {
        return desempeño;
    }

    public int getPuntuacionMaxima() {
        return puntuacionMaxima;
    }
    
    @Override
    public void setNumeroFase(int fase) {
        this.numeroFase=fase;
    }

    @Override
    public void setPuntuacionDesempeño(int valor) {
        this.puntuacionMaxima=valor;
    }

    @Override
    public void setPuntuacionMaxima(int valor) {
        this.puntuacionMaxima=valor;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fechaInicio=fecha;
    }

    @Override
    public int getNumeroFase() {
        return numeroFase;
    }

    @Override
    public int getPuntuacionDesempeño() {
        return desempeño;
    }

    @Override
    public int getPorcentajeDesempeño() {
        return 0; /*duda*/
    }

    @Override
    public Date getFecha() {
        return fechaInicio;
    }

    @Override
    public Object getPropiedad(int tipo) {
        if(tipo == 1){
            return fechaFin;
            
        }
        return null;
        
    }

    @Override
    public void setPropiedades(Hashtable datos) {
        
    }

 
}
