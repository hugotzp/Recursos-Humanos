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
public class Comision implements Aumento{
    float totalVenta;
    float porcentaje;  
    @Override
    public float calcularTotal() {
        return totalVenta * porcentaje;
    }
    
}
