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
public interface PagoTrabajador {
    public float getTotalAPagar();
    public void setVariacionSalarial(VariacionSalarial variacion);
    public void setEmpleado(Empleo empleado);
    public void setTotalPagar(float total);
    public void calculartotalPagar();
    public void obtenerVariaciones();
    public void obtenerFormaPago();
    public void guardarBase();
    public void setFormaDePago(FormaDePago pago);
    public FormaDePago getFormaDePago();
    public void pagar();
}
