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
public class PermisosModulo implements AdaptadorPermisos{
    
    
    public Hashtable permisos;
    
    public void agregarPermisoModulo(String nombre,String objeto){
        
        permisos.put(nombre, objeto);
        
    }
    
    
    @Override
    public Hashtable getListadoPermisos() {
        return permisos;        
    }
    
    
    
}
