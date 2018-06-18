/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import OtrasClases.CreadorIterador;
import OtrasClases.Iterador;
import OtrasClases.IteradorVariaciones;
import OtrasClases.IteratorCollection;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class PagoEmpleado implements PagoTrabajador{
    float TotalPagar;
    FormaDePago TipoPago;
    Empleo Trabajador;
    ArrayList<VariacionSalarial> VariacionesSalariales;
    
    public PagoEmpleado(FormaDePago pago,Empleo Trabajador){
        this.TotalPagar = 0;
        this.TipoPago = pago;
        this.Trabajador = Trabajador;
        this.VariacionesSalariales = new ArrayList<>();
    }

    @Override
    public float getTotalAPagar() {
        return TotalPagar;
    }

    @Override
    public void setVariacionSalarial(VariacionSalarial variacion) {
        this.VariacionesSalariales.add(variacion);
    }

    @Override
    public void setEmpleado(Empleo empleado) {
        this.Trabajador = empleado;
    }

    @Override
    public void setTotalPagar(float total) {
        this.TotalPagar = total;
    }

    @Override
    public void calculartotalPagar() {
        float auxTotal = 0;
        //Obtener sueldo base
        //auxTotal += Trabajador.getSueldo();
        IteratorCollection constructor = new CreadorIterador();
        IteradorVariaciones lista = constructor.crearIteradorVariaciones();
        lista.setVariaciones(VariacionesSalariales);
        while(lista.hasMore()){
            auxTotal = lista.getNext().modificarSalario(auxTotal);
        }
        TotalPagar = auxTotal;
    }
}
