/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.ModuloContratacion;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public class Aspirantes implements PersonasInteresadas{
    
    public boolean enProceso;
    public float salarioEsperado;
    
    
    
    @Override
    public void setTipoProceso(boolean tipo) {
        
    }

    @Override
    public boolean getTipoProceso() {
        return false;
        
    }

    @Override
    public void setFaseReclutamiento(FaseReclutamiento fase) {
        
    }

    @Override
    public ArrayList getFaseReclutamiento() {
        return null;
        
    }

    @Override
    public int obtenerPromedioDesempeñoTotal() {
        return 0;
        
    }
    
}
