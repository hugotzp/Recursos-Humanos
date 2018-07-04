/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.Hashtable;

/**
 *
 * @author Edwin Chocoy
 */
public class AdministradorPermisos {
    
    public AdaptadorPermisos modulo;
    public PermisosModulo permisosM;
    public Hashtable permisos;
    
    public void asignarPermisos(boolean valor,String nombrePermiso){
        this.permisos.put(nombrePermiso, valor);
    }   
    
    public void guardarPermiso(){
        
    }
    
    
}
