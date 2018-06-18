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
public class Bonificacion implements VariacionSalarial{
    final static public int pValor = 1;
    private float valorBono;
    
    public Bonificacion(){
        valorBono = 0;
    }
    
    public void setValorBono(float valor){
        this.valorBono = valor;
    }
    
    @Override
    public float calcularTotal() {
        return valorBono;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pValor:
                return valorBono;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        return sueldoActual+valorBono;
    }
}
