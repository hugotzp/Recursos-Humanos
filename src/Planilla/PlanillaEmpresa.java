/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class PlanillaEmpresa {
    Date fecha;
    ArrayList<PlanillaAreaTrabajo> Planillas;
    
    public PlanillaEmpresa(Date fecha){
        this.fecha = fecha;
        this.Planillas = new ArrayList<>();
    }
    
    public void mostrarPlanilla(){
        
    }
    
    public void pagarPlanilla(){
        
    }
}
