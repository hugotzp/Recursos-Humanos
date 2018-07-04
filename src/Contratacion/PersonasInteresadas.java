
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contratacion;


import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface PersonasInteresadas {
    
    public void setTipoProceso(boolean tipo);
    
    public boolean getTipoProceso();
    
    public void setFasesReclutamiento(FaseReclutamiento fase);

    public ArrayList getFasesReclutamiento();
    
}
