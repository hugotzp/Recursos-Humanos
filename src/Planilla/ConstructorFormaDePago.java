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
public interface ConstructorFormaDePago {
    public void buildPart(int tipo, Object parte);
    public void setFormaPago(FormaDePago pago);
    public FormaDePago getFormaPago();
    public void reset();
}
