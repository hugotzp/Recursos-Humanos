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
public interface FormaDePago {
    public boolean pagar(float TotalPagar);
    public void setNumeroDocumento(String numero);
    public String getNumeroDocumento();
    public Object getPropiedad(int tipo);
}
