/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Conexion.Conexion;
import Estructura.AdministradorDepartamentos;
import Estructura.Departamentos;
import Estructura.Trabajador;
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
    AdministradorDepartamentos AdaptadorDepartamentos; 
    
    public PlanillaEmpresa(Date fecha){
        this.fecha = fecha;
        this.Planillas = new ArrayList<>();
    }
    
    public void setPlanilla(PlanillaAreaTrabajo planilla){
        this.Planillas.add(planilla);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPlanillas(ArrayList<PlanillaAreaTrabajo> Planillas) {
        this.Planillas = Planillas;
    }

    public void setAdaptadorDepartamentos(AdministradorDepartamentos AdaptadorDepartamentos) {
        this.AdaptadorDepartamentos = AdaptadorDepartamentos;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<PlanillaAreaTrabajo> getPlanillas() {
        return Planillas;
    }

    public AdministradorDepartamentos getAdaptadorDepartamentos() {
        return AdaptadorDepartamentos;
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
        Conexion con = Conexion.getConexion();
        JpaControllerPlanilla p = new JpaControllerPlanilla(con.getEMF());
        ArrayList<Departamentos> departamentosOrganizacion = AdaptadorDepartamentos.getDepartamentos();
        for (Departamentos departamento : departamentosOrganizacion) {
            PlanillaDepartamento planilla = p.findPlanillaDepartamento(departamento.getId());
            planilla.setNombreSector(departamento.getNombre());
        }
        
    }
    
    public void crearNuevaPlanillaEmpresa(){
        
    }
}
