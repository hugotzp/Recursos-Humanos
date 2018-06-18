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
public class ConstructorEfectivo implements ConstructorFormaDePago{
    Efectivo pago;
    final public static int pNumeroBoleta = 1;
    
    public ConstructorEfectivo(Efectivo pago){
        this.pago = pago;
    }

    @Override
    public void buildPart(int tipo, Object parte) {
        switch(tipo){
            case pNumeroBoleta:
                pago.setNumeroDocumento((String)parte);
                break;
        }
    }

    @Override
    public void setFormaPago(FormaDePago pago) {
        this.pago = (Efectivo)pago;
    }

    @Override
    public FormaDePago getFormaPago() {
        return this.pago;
    }

    @Override
    public void reset() {
        this.pago =  null;
    }
    
}
