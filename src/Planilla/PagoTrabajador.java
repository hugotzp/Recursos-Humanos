/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Estructura.Trabajadores;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Hugo
 */
public interface PagoTrabajador {
    public float getTotalAPagar();
    public void setVariacionSalarial(VariacionSalarial variacion);
    public void setEmpleado(Trabajadores empleado);
    public void setTotalPagar(float total);
    public void calculartotalPagar();
    public void obtenerVariaciones();
    public void obtenerFormaPago();
    public void guardarBase();
    public void setFormaDePago(FormaDePago pago);
    public FormaDePago getFormaDePago();
    public void pagar();
    public Hashtable<String,ConstructorVariacionSalarial> getVariacionSalarial();
    public Trabajadores getTrabajador();
}
