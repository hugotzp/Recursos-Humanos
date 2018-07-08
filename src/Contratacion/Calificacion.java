
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
public interface Calificacion {


    public void setNumeroFase(int fase); 

    public void setPuntuacionDesempeño(int valor);  

    public void setFechaInicio(Date fecha);
    
    public void setFechaFin(Date fecha);
    
    public int getNumeroFase();
    
    public int getPuntuacionDesempeño();
        
    public Date getFechaInicio();
    
    public Date getFechaFin();
    
    public Object getPropiedad(int tipo);


}
