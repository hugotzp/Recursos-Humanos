/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.ModuloContratacion;

import java.util.Date;

/**
 *
 * @author Edwin Chocoy
 */
public class Entrevista implements FaseReclutamiento{

    public Date fecha;
    public int desempeno;
    public int rangoBajo;
    public int rangoAlto;
    
    
    
    @Override
    public void getTipoFase() {
        
    }

    @Override
    public void getDesempeño() {
        
    }

    @Override
    public void setRangoDesempeño(int bajo, int alto) {
        
        this.rangoAlto=alto;
        this.rangoBajo=bajo;
        
    }
    
}
