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
public class Planilla {
    Date fecha;
    ArrayList<PlanillaAreaTrabajo> planillasAreasTrabajo;
    public Planilla(Date fecha){
        this.fecha = fecha;
        planillasAreasTrabajo = new ArrayList<PlanillaAreaTrabajo>();
    }
    
    public void agregarPlanilla(PlanillaAreaTrabajo planilla){
        planillasAreasTrabajo.add(planilla);
    }
    
    public void mostrarPlanilla(){
        
    }
    
}
