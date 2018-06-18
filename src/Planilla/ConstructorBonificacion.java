/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

/**
 *
 * @author Hugo
 */
public class ConstructorBonificacion implements ConstructorVariacionSalarial{
    final public static int pValorBono = 1;
    Bonificacion variacion;
    
    public ConstructorBonificacion(Bonificacion variacion){
        this.variacion = variacion;
    }

    @Override
    public void buildPart(int tipo, Object objeto) {
        switch(tipo){
            case pValorBono:
                variacion.setValorBono((float)objeto);
                break;
        }
    }

    @Override
    public void setVariacion(VariacionSalarial variacion) {
        this.variacion = (Bonificacion)variacion;
    }

    @Override
    public VariacionSalarial getVariacion() {
        return variacion;
    }

    @Override
    public void reset() {
        variacion = null;
    }
}
