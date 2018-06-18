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
public class Cheque implements FormaDePago{
    final public static int pCuentaEmpresa = 1;
    private String numeroCheque;
    private String cuentaEmpresa;
    
    public Cheque(){
        numeroCheque = "";
        cuentaEmpresa = "";
    }
    
    public void setCuenta(String cuenta){
        this.cuentaEmpresa = cuenta;
    }

    @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroCheque = numero;
    }

    @Override
    public String getNumeroDocumento() {
        return numeroCheque;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pCuentaEmpresa:
                return cuentaEmpresa;
            default:
                return null;
        }
    }

}
