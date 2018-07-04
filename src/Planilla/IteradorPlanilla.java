/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import OtrasClases.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class IteradorPlanilla implements Iterator{
    private ArrayList<PagoTrabajador> Trabajadores;
    private int posicionActual;
    
    public IteradorPlanilla(){
        this.Trabajadores = new ArrayList<>();
        this.posicionActual = 0;
    }
    
    public IteradorPlanilla(ArrayList<PagoTrabajador> trabajadores){
        this.Trabajadores = trabajadores;
        this.posicionActual = 0;
    }
    
    public PagoTrabajador getNext(){
        if(hasMore()){
            posicionActual++;
            return Trabajadores.get(posicionActual);
        }else{
            return null;
        }
    }
    
    public boolean hasMore(){
        return posicionActual <= Trabajadores.size();
    }
    
    public void reset(){
        posicionActual = 0;
    }
}
