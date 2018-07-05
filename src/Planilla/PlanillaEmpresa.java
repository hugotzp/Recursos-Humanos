/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Conexion.Conexion;
import Estructura.Departamentos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
    
    public void setPlanilla(PlanillaAreaTrabajo planilla){
        this.Planillas.add(planilla);
    }
    
    public void mostrarPlanilla(){
        
    }
    
    public void pagarPlanilla(){
        for(PlanillaAreaTrabajo area : Planillas){
            IteradorPlanilla iterador = (IteradorPlanilla) ((PlanillaDepartamento)area).crearIterador();
            while(iterador.hasMore()){
                iterador.getNext().pagar();
            }
        }
    }
    
    public void GuardarPlanilla(){
        Conexion con = Conexion.getConexion();
        JpaControllerPlanilla p = new JpaControllerPlanilla(con.getEMF());
        for(PlanillaAreaTrabajo area : Planillas){
            PlanillaDepartamento dep = (PlanillaDepartamento) area;
            if(dep.getId()<0) p.create(dep);
            dep.guardar();
        }
    }
    
    public void obtenerPlanillaBase(){
        
    }
    
    public void crearNuevaPlanillaEmpresa(){
        
    }
}
