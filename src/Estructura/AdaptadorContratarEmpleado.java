/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Conexion.Conexion;

/**
 *
 * @author Edwin Chocoy
 */
public class AdaptadorContratarEmpleado {
    private ContratacionEmpleados medioContratacion;
    private AdministradorEmpleos admonEmpleos;
    
    public AdaptadorContratarEmpleado(){
        Conexion c = Conexion.getConexion();       
        medioContratacion = new JpaControllerTrabajador(c.getEMF());
        admonEmpleos = new JpaControllerEmpleo(c.getEMF());
    }
    
    public Long guardarEmpleo(String nombre) {
        Empleo ed = admonEmpleos.Existe(nombre);
        if(ed!=null) return ed.getId() ;
        else return admonEmpleos.guardarEmpleo(nombre);
        
    }
    
    public String getEmpleo(Long id) {
        return admonEmpleos.getEmpleo(id);
    }
    
    public void contratarEmpleado(Long idPersona, Long idEmpleado, Long idDepartamento, float salarioBase) {
        medioContratacion.contratarEmpleado(idPersona, idEmpleado, idDepartamento, salarioBase);
    }
}
