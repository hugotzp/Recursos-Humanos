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
public interface ConstructorVariacionSalarial {
    public void buildPart(int tipo, Object objeto);
    public void setVariacion(VariacionSalarial variacion);
    public VariacionSalarial getVariacion();
    public void reset();
}
