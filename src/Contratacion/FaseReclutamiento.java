package Contratacion;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Edwin Chocoy
 */
public interface FaseReclutamiento {
    /**
     *
     * @param fase
     */
    public void setNumeroFase(int fase);
    
    /**
     *
     * @param valor
     */
    public void setPuntuacionDesempeño(int valor);
    
    /**
     *
     * @param valor
     */
    public void setPuntuacionMaxima(int valor);
    
    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha);
    
    public int getNumeroFase();
    
    public int getPuntuacionDesempeño();
    
    public int getPorcentajeDesempeño();
    
    public Date getFecha();
    
    public Object getPropiedad(int tipo);
}
