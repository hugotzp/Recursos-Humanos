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
public class Efectivo implements FormaDePago{
    String numeroBoleta;
    
    public Efectivo(){
        this.numeroBoleta = "";
    }
    @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroBoleta =  numero;
    }

    @Override
    public String getNumeroDocumento() {
        return this.numeroBoleta;
    }

    @Override
    public Object getPropiedad(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
