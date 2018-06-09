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
    public float calcularTotalAPagar();
    public void setAumento(Aumento aumento);
    public void setEmpleado(Empleo empleado);
    public void setPrestacionesLaborales(PrestacionesLaborales prestacion);
    public void setDescuentos(Descuento descuento);
}
