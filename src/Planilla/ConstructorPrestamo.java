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
public class ConstructorPrestamo implements ConstructorVariacionSalarial{
    final static public int pTotalPrestamo = 1;
    final static public int pNumeroPagos = 2;
    Prestamo variacion;
    
    public ConstructorPrestamo(Prestamo variacion){
        this.variacion = variacion;
    }

    @Override
    public void buildPart(int tipo, Object objeto) {
        switch(tipo){
            case pTotalPrestamo:
                variacion.setTotalPrestamo((float) objeto);
                break;
            case pNumeroPagos:
                variacion.setNumeroPagos((float)objeto);
                break;
        }
    }

    @Override
    public void setVariacion(VariacionSalarial variacion) {
        this.variacion = (Prestamo) variacion;
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
