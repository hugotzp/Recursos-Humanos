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
public class ConstructorHorasExtra implements ConstructorVariacionSalarial{
    final static public int pNumeroHorasExtra = 1;
    final static public int pSalarioBase = 2;
    HorasExtra variacion;
    
    public ConstructorHorasExtra(HorasExtra variacion){
        this.variacion = variacion;
    }

    @Override
    public void buildPart(int tipo, Object objeto) {
        switch(tipo){
            case pNumeroHorasExtra:
                variacion.setNumeroHorasExtra((float) objeto);
                break;
            case pSalarioBase:
                variacion.setSalarioBase((float)objeto);
                break;
        }
    }

    @Override
    public void setVariacion(VariacionSalarial variacion) {
        this.variacion = (HorasExtra) variacion;
    }

    @Override
    public VariacionSalarial getVariacion() {
        return variacion;
    }

    @Override
    public void reset() {
        this.variacion = null;
    }
    
    
}
