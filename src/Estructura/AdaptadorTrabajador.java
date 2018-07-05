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
public class AdaptadorTrabajador {
    private AdministradorTrabajador admonTrabajador;
    
    public AdaptadorTrabajador(){
        Conexion c = Conexion.getConexion();       
        admonTrabajador = new JpaControllerTrabajador(c.getEMF());
    }
    
    public Trabajador getTrabajador(Long id){
        return admonTrabajador.getTrabajador(id);
    }
}
