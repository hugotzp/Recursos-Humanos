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
public interface PlanillaAreaTrabajo {
    public void setPagoTrabajador(PagoTrabajador trabajador);
    public ArrayList<PagoTrabajador> getPagoTrabajadores();
    public float obtenerTotalPagoPlanilla();
    public void guardar();
    public void obtenerPagosPlanilla();
}
