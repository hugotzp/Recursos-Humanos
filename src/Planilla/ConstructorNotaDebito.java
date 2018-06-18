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
public class ConstructorNotaDebito implements ConstructorFormaDePago{
    NotaDebito pago;
    final public static int pCuentaEmpresa = 1;
    final public static int pCuentaEmpleado = 2;
    final public static int pNumeroNota = 3;
    
    public ConstructorNotaDebito(NotaDebito pago){
        this.pago = pago;
    }

    @Override
    public void buildPart(int tipo, Object parte) {
        switch(tipo){
            case pCuentaEmpresa:
                pago.setCuentaEmpresa((String)parte);
                break;
            case pCuentaEmpleado:
                pago.setCuentaEmpleado((String)parte);
                break;
            case pNumeroNota:
                pago.setNumeroDocumento((String)parte);
                break;
        }
    }

    @Override
    public void setFormaPago(FormaDePago pago) {
        this.pago = (NotaDebito)pago;
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
