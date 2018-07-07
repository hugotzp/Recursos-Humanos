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
    
    public PlanillaEmpresa(){
        this.fecha = new Date();
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
            dep.setFecha(fecha);
            if(dep.getId()<0) p.create(dep);
            dep.guardar();
        }
    }
    
    public void obtenerPlanillaBase(){
        Conexion con = Conexion.getConexion();
        JpaControllerPlanilla p = new JpaControllerPlanilla(con.getEMF());
        ArrayList<Departamentos> departamentosOrganizacion = AdaptadorDepartamentos.getIdDepartamentos();
        for (Departamentos departamento : departamentosOrganizacion) {
            PlanillaDepartamento planilla = p.obtenerPlanilla(departamento.getId(),fecha);
            planilla.setNombreSector(departamento.getNombre());
            planilla.obtenerPagosPlanilla();
            Planillas.add(planilla);
        }
        
    }
    
    public void crearNuevaPlanillaEmpresa(){
        ArrayList<Departamentos> departamentosOrganizacion = AdaptadorDepartamentos.getEstructura();
        for (Departamentos departamento : departamentosOrganizacion) {
            System.out.println(departamento.getNombre());
            PlanillaDepartamento planilla = new PlanillaDepartamento(departamento.getNombre(), departamento.getId());
            ArrayList<Trabajador> trabajadores = departamento.getPersonal();
            for(Trabajador t :trabajadores){
                System.out.println(t.NombreEmpleo);
                PagoEmpleado pago = new PagoEmpleado();
                pago.setTrabajador(t);
                planilla.setPagoTrabajador(pago);
            }
            Planillas.add(planilla);
        }
    }
}
