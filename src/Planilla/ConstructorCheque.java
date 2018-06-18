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
public class ConstructorCheque implements ConstructorFormaDePago{
    Cheque pago;
    final public static int pNumeroCheque = 1;
    final public static int pCuentaEmpresa = 2;
    
    public ConstructorCheque(Cheque pago){
        this.pago = pago;
    }

    @Override
    public void buildPart(int tipo, Object parte) {
        switch(tipo){
            case pNumeroCheque:
                pago.setNumeroDocumento((String)parte);
                break;
            case pCuentaEmpresa:
                pago.setCuenta((String)parte);
                break;
        }
    }
    
    @Override
    public void setFormaPago(FormaDePago pago) {
        this.pago = (Cheque)pago;
    }

    @Override
    public FormaDePago getFormaPago() {
        return this.pago;
    }

    @Override
    public void reset() {
        this.pago = null;
    }

}
