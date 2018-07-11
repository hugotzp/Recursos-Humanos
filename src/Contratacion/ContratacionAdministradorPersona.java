/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Conexion.Conexion;
import Estructura.JpaControllerEmpleo;
import Estructura.JpaControllerTrabajador;
import Personas.*;

/**
 *
 * @author Edwin Chocoy
 */
public class ContratacionAdministradorPersona {
    private AdaptadorContratacion adaptador;
    
    public ContratacionAdministradorPersona(){
        Conexion c = Conexion.getConexion();       
        adaptador = new JpaController_PersonalContratacion(c.getEMF());
    }
    
    public Persona getPersona(Long idPersona){
        return adaptador.getPersona(idPersona.intValue());
    }
    
    public void guardarPersona(Persona persona){
        adaptador.guardarPersona(persona);
    }
}
