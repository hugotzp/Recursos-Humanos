/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class Evaluar implements Evaluacion{
    
    FormaCalificar tipoEvaluacion;
    
    public Evaluar(FormaCalificar tipo){
        this.tipoEvaluacion = tipo;
    }
    
    @Override
    public ArrayList<Aspirantes> seleccionarAspirantes() {
        return tipoEvaluacion.ejecutar();
    }
    
}
