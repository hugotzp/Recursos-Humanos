/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class PlanillaDepartamento implements PlanillaAreaTrabajo{
    String nombreSector;
    FormaDePago TipoPago;
    ArrayList<PagoTrabajador> Trabajadores;
    
    public PlanillaDepartamento(String nombre, FormaDePago tipoPago){
        this.nombreSector = nombre;
        this.TipoPago = tipoPago;
        this.Trabajadores = new ArrayList<>();
    }

    @Override
    public void setTipoPago(FormaDePago pago) {
        this.TipoPago = pago;
    }

    @Override
    public void setPagoTrabajador(PagoTrabajador trabajador) {
        this.Trabajadores.add(trabajador);
    }

    @Override
    public FormaDePago getTipoPago() {
        return this.TipoPago;
    }

    @Override
    public ArrayList<PagoTrabajador> getPagoTrabajadores() {
        return this.Trabajadores;
    }

    @Override
    public float obtenerTotalPagoPlanilla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
