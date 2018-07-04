/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import OtrasClases.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public class IteradorFases implements Iterator {
    
    ArrayList<FaseReclutamiento> fases;
    private int posicionActual=0;
    
    
    public IteradorFases(Aspirantes a){
        this.fases=a.getFasesReclutamiento();
    }
    
    @Override
    public FaseReclutamiento getNext() {
        FaseReclutamiento obj = null;
        if( (this.posicionActual ) < this.fases.size() )
        {
            obj = this.fases.get(this.posicionActual);
            this.posicionActual = this.posicionActual + 1;
        }
        return obj;
    }

    @Override
    public boolean hasMore() {
        boolean ok = false;
        if( this.posicionActual < (this.fases.size() ) )
        {
            ok = true;
        }
        return ok;
    }

    @Override
    public void reset() {
        posicionActual = 0;
    }
    
}
