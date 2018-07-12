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
        PersonasInteresadas obj = null;
        if( (this.posicionActual ) < this.aspirantes.size() )
        {
            obj = this.aspirantes.get(this.posicionActual);
            this.posicionActual = this.posicionActual + 1;
        }
        return obj;
    }
    @Override
    public boolean hasMore(){
        boolean ok = false;
        if( this.posicionActual < (this.aspirantes.size() ) )
        {
            ok = true;
        }
        return ok;
    }
    @Override
    public void reset(){
        posicionActual = 0;
    }
    

}
