/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;


import OtrasClases.IterableCollection;
import OtrasClases.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class PlanillaDepartamento implements PlanillaAreaTrabajo,IterableCollection{
    String nombreSector;
    ArrayList<PagoTrabajador> Trabajadores;
    
    public PlanillaDepartamento(String nombre, FormaDePago tipoPago){
        this.nombreSector = nombre;
        this.Trabajadores = new ArrayList<>();
    }

    @Override
    public void setPagoTrabajador(PagoTrabajador trabajador) {
        this.Trabajadores.add(trabajador);
    }

    @Override
    public ArrayList<PagoTrabajador> getPagoTrabajadores() {
        return this.Trabajadores;
    }

    @Override
    public float obtenerTotalPagoPlanilla() {
        IteradorPlanilla planilla = (IteradorPlanilla) crearIterador();
        float Total=0;
        while(planilla.hasMore()){
            Total += planilla.getNext().getTotalAPagar();
        }
        return Total;
    }

    @Override
    public Iterator crearIterador() {
        return new IteradorPlanilla(Trabajadores);
    }
}
