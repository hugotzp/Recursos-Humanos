/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Hugo
 */
public class HorasExtra implements VariacionSalarial{
    final public static int pNumeroHorasExtra = 1;
    final public static int pSalarioBase = 2;
    final public static int pTotal = 3;
    float numeroHorasExtra;
    float salarioBase;
    float total;
    static float porcentajeHoraExtra = (float)1.5;
    static float totalHorasLaboradas = 8;
    
    public HorasExtra(){
        this.numeroHorasExtra = 0;
        this.salarioBase = 0;
        this.total = 0;
    }
    
    public void setHorasExtra(float cantidadHorasExtra){
        this.numeroHorasExtra = cantidadHorasExtra;
    }
    
    public void setSalarioBase(float salarioBase){
        this.salarioBase = salarioBase;
    }

    @Override
    public float calcularTotal() {
        Calendar fecha = new GregorianCalendar();
        float diasTotales = 0;
        if(fecha.getActualMaximum(Calendar.DAY_OF_MONTH)<=30) diasTotales = 30;
        else diasTotales = 31;
        float pagoPorHora = (salarioBase/diasTotales)/totalHorasLaboradas;
        total = numeroHorasExtra * pagoPorHora;
        return total;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pNumeroHorasExtra:
                return numeroHorasExtra;
            case pSalarioBase:
                return salarioBase;
            case pTotal:
                return total;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        if(total ==0){
            calcularTotal();
        }
        return sueldoActual + total;
    }
    
}
