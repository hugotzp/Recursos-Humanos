/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Conexion.Conexion;
import Estructura.AdaptadorContratarEmpleado;
import Estructura.Departamentos;
import Estructura.Empleo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Edwin Chocoy
 */
public class Contratacion implements ModuloContratacion {
   
    public ArrayList fasesExistentes;
    public ArrayList reclutamientos;
    
    public void Contratacion(){
        this.reclutamientos = new ArrayList();
    }
    
    public String obtenerEmpleo(Long id){
        AdaptadorContratarEmpleado c = new AdaptadorContratarEmpleado();
        return c.getEmpleo(id);
    }
    
    public String obtenerDepartamento(Long id){
        AdaptadorDepartamentos c = new AdaptadorDepartamentos();
        return c.getDepartamento(id).getNombre();
    }
    
    @Override
    public void obtenerReclutamientos() {
        Conexion con = Conexion.getConexion();
        JpaControllerReclutar re = new JpaControllerReclutar(con.getEMF());
        this.reclutamientos = new ArrayList(re.findReclutarEntities());
    }

    @Override
    public void guardarReclutamiento(Reclutar reclutamiento) {
        try {
            Conexion con = Conexion.getConexion();
            JpaControllerReclutar re = new JpaControllerReclutar(con.getEMF());
            re.create(reclutamiento);
        } catch (Exception ex) {
            Logger.getLogger(Contratacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Long guardarEmpleo(String nombre){
        AdaptadorContratarEmpleado ed = new AdaptadorContratarEmpleado();
        return ed.guardarEmpleo(nombre);
    }
    
    
    public ArrayList<Departamentos> obtenerDepartamentos(){
        AdaptadorDepartamentos dep = new AdaptadorDepartamentos();
        return dep.getDepartamentos();
    }
    

    @Override
    public void contratarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearFaseReclutamiento(String nombre) {
        JpaControllerFaseReclutamiento f = new JpaControllerFaseReclutamiento(Conexion.getConexion().getEMF());
        FaseReclutamiento fase = new FaseReclutamiento();
        fase.setNombre(nombre);
        f.create(fase);
    }

    @Override
    public void obtenerFasesReclutamientoExistentes() {
        JpaControllerFaseReclutamiento f = new JpaControllerFaseReclutamiento(Conexion.getConexion().getEMF());
        fasesExistentes.addAll(f.findFaseReclutamientoEntities());
    }
    
    public ArrayList obtenerPropuestas(){
        JpaControllerPropuestaEmpleo p = new JpaControllerPropuestaEmpleo(Conexion.getConexion().getEMF());
        return new ArrayList(p.findPropuestaEmpleoEntities());
    }

    public ArrayList getFasesExistentes() {
        return fasesExistentes;
    }

    public ArrayList getReclutamientos() {
        return reclutamientos;
    }
    
    
}
