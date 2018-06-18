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
public class IGSS implements VariacionSalarial{
    final static public int pSalarioBase = 1;
    final static public int pTotal = 2;
    final static public int pHorasExtra = 3;
    private float salarioBase;
    private float horasExtra;
    static public float porcentaje = (float)2.83;
    private float Total;
    
    public IGSS(){
        this.salarioBase = 0;
        this.horasExtra = 0;
        this.Total = 0;
    }
    
    public void setSalarioBase(float salario){
        this.salarioBase = salario;
    }
    
    public void setHorasExtra(float horas){
        this.horasExtra = horas;
    }

    @Override
    public float calcularTotal() {
        Total = (salarioBase+horasExtra) * porcentaje;
        return Total;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pSalarioBase:
                return salarioBase;
            case pTotal:
                return Total;
            case pHorasExtra:
                return horasExtra;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        if(Total == 0){
            calcularTotal();
        }
        return sueldoActual - Total;
    }
    
}
