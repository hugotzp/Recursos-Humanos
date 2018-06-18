
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

public class Entrevista implements FaseReclutamiento,MetodosConstructorFases{

    public Date fecha;
    public int desempeño;
    public int puntuacionMaxima;
    public int numeroFase;
    public String nombreFase;

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
        this.fecha=fecha;
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
        return fecha;
    }

    @Override
    public Object getPropiedad(int tipo) {
        return null;


        
    }

    @Override

    public void setPropiedades(Hashtable datos) {
        
    }

}
