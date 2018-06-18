/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtrasClases;

import Planilla.VariacionSalarial;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class IteradorVariaciones implements Iterador{
    ArrayList<VariacionSalarial> Variaciones;
    int posicionActual;
    
    IteradorVariaciones(){
        reset();
    }
    
    public void setVariaciones(ArrayList<VariacionSalarial> variaciones){
        this.Variaciones = variaciones;
    }
    
    @Override
    public boolean hasMore() {
        return posicionActual < Variaciones.size()-1;
    }

    @Override
    public VariacionSalarial getNext() {
        if(hasMore()){
            posicionActual++;
            return Variaciones.get(posicionActual);
        }else{
            return null;
        }
    }
    
    public void reset(){
        Variaciones = new ArrayList<>();
        posicionActual = -1;
    }
    
}
