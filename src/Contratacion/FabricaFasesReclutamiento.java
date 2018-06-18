/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

/**
 *
 * @author Edwin Chocoy
 */
public class FabricaFasesReclutamiento implements Factory{
    
    FaseReclutamiento fase;
    
    @Override
    public FaseReclutamiento crearObjeto(int tipo) {
        if (tipo ==1 ){
            fase = new Entrevista();
        }
        else if(tipo == 2){
            fase = new Entrenamiento();
        }
        
        return fase;
        
    }
    
}
