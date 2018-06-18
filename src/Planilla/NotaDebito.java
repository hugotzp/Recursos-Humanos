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
public class NotaDebito implements FormaDePago{
    final public static int pCuentaEmpresa = 1;
    final public static int pCuentaEmpleado = 2;
    String cuentaEmpresa;
    String cuentaEmpleado;
    String numeroNota;
    
    public NotaDebito(){
        this.cuentaEmpresa = "";
        this.cuentaEmpleado = "";
        this.numeroNota = "";
    }
    
    public void setCuentaEmpresa(String cuenta){
        this.cuentaEmpresa = cuenta;
    }
    
    public void setCuentaEmpleado(String cuenta){
        this.cuentaEmpleado = cuenta;
    }

    @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroNota = numero;
    }

    @Override
    public String getNumeroDocumento() {
        return this.numeroNota;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pCuentaEmpresa:
                return cuentaEmpresa;
            case pCuentaEmpleado:
                return cuentaEmpleado;
            default:
                return null;
        }
    }
}
