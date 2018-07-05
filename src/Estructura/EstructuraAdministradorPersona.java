/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Conexion.Conexion;
import Personas.AdaptadorEstructura;
import Personas.JpaController_PersonalEstructura;
import Personas.*;

/**
 *
 * @author Edwin Chocoy
 */
public class EstructuraAdministradorPersona {
    
    private AdaptadorEstructura adaptador;
    
    public Persona getPersona(int id){
                
        Conexion con = Conexion.getConexion();
        adaptador = new JpaController_PersonalEstructura(con.getEMF());
        
        return adaptador.getPersona(id);
    }
}
