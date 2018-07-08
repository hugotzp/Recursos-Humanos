/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Contratacion.PersonasInteresadas;
import OtrasClases.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class IteradorVariaciones implements Iterator{
    private ArrayList<VariacionSalarial> Variaciones;
    private int posicionActual;
    
    public IteradorVariaciones(){
        this.Variaciones = new ArrayList<>();
        this.posicionActual = 0;
    }
    
    public IteradorVariaciones(ArrayList<VariacionSalarial> variaciones){
        this.Variaciones = variaciones;
        this.posicionActual = 0;
    }
    
    public VariacionSalarial getNext(){
        if(hasMore()){
            posicionActual++;
            return Variaciones.get(posicionActual-1);
        }else{
            return null;
        }
    }
    
    public boolean hasMore(){
        return posicionActual < Variaciones.size();
    }
    
    public void reset(){
        posicionActual = 0;
    }
}
