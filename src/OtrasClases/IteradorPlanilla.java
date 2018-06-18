/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtrasClases;

import Planilla.PagoTrabajador;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class IteradorPlanilla implements Iterador{
    ArrayList<PagoTrabajador> Trabajadores;
    int posicionActual;
    
    IteradorPlanilla(){
        reset();
    }
    
    public void setArray(ArrayList<PagoTrabajador> lista){
        this.Trabajadores = lista;
    }
    
    @Override
    public PagoTrabajador getNext(){
        if(hasMore()){
            posicionActual++;
            return Trabajadores.get(posicionActual);
        }else{
            return null;
        }
    }
    @Override
    public boolean hasMore() {
        return posicionActual < Trabajadores.size()-1;
    }

    public void reset(){
        Trabajadores = new ArrayList<>();
        posicionActual = -1;
    }

}
