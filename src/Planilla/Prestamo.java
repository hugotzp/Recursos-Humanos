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
public class Prestamo implements VariacionSalarial{
    final public static int pTotalPrestamo = 1;
    final public static int pNumeroPagos = 2;
    final public static int pTotal = 3;
    private float TotalPrestamo;
    private float NumeroPagos;
    private float Total;
    
    public Prestamo(){
        this.TotalPrestamo = 0;
        this.NumeroPagos = 0;
        this.Total = 0;
    }
    
    public void setTotalPrestamo(float total){
        this.TotalPrestamo = total;
    }
    
    public void setNumeroPagos(float total){
        this.NumeroPagos = total;
    }

    @Override
    public float calcularTotal() {
        float totalAPagar=0;
        totalAPagar = TotalPrestamo / NumeroPagos;
        Total = totalAPagar;
        return totalAPagar;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pNumeroPagos:
                return NumeroPagos;
            case pTotal:
                return Total;
            case pTotalPrestamo:
                return TotalPrestamo;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        if(Total == 0){
            return sueldoActual - calcularTotal();
        }else{
            return sueldoActual - Total;
        }
    }
}
