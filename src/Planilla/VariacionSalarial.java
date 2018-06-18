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
public interface VariacionSalarial {
    public float calcularTotal();
    public Object getPropiedad(int tipo);
    public float modificarSalario(float sueldoActual);
}
