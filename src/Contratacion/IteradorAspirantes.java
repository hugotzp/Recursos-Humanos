/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
class IteradorAspirantes implements Iterador {
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
    
    public boolean hasMore(){
        return posicionActual <= aspirantes.size();
    }
    
    public void reset(){
        posicionActual = 0;
    }
}
