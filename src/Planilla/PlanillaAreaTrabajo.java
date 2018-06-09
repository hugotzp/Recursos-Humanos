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
public interface PlanillaAreaTrabajo {
    public void setTipoPago(FormaDePago pago);
    public float obtenerTotalPagar();
    public void setPagoTrabajador(PagoTrabajador pago);
}
