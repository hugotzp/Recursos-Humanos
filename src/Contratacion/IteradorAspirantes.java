/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;
import OtrasClases.*;

/**
 *
 * @author Hugo
 */
class IteradorAspirantes implements Iterator{
    
    ArrayList<Aspirantes> aspirantes;
    int posicionActual;
    
    public IteradorAspirantes(ArrayList<Aspirantes> aspirantes){
        this.aspirantes = aspirantes;
        posicionActual = 0;
    }
    
    public PersonasInteresadas getNext(){
        if(hasMore()){
            posicionActual++;
            return aspirantes.get(posicionActual);
        }else{
            return null;
        }
    }
    @Override
    public boolean hasMore(){
        return posicionActual <= aspirantes.size();
    }
    @Override
    public void reset(){
        posicionActual = 0;
    }
    
    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
