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
public class ConstructorIgss implements ConstructorVariacionSalarial{
    final static public int pSalarioBase = 1;
    final static public int pHorasExtra = 2;
    IGSS variaion;
    
    public ConstructorIgss(IGSS variacion){
        this.variaion = variacion;
    }

    @Override
    public void buildPart(int tipo, Object objeto) {
        switch(tipo){
            case pSalarioBase:
                variaion.setSalarioBase((float) objeto);
                break;
            case pHorasExtra:
                variaion.setHorasExtra((float)objeto);
                break;
        }
    }

    @Override
    public void setVariacion(VariacionSalarial variacion) {
        this.variaion = (IGSS) variacion;
    }

    @Override
    public VariacionSalarial getVariacion() {
        return variaion;
    }

    @Override
    public void reset() {
        variaion = null;
    }
}
