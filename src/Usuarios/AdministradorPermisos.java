/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Conexion.Conexion;
import Estructura.JpaControllerEmpleo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

/**
 *
 * @author Edwin Chocoy
 */
public class AdministradorPermisos {
    
    public AdaptadorPermisos modulo;
    public PermisosModulo permisosM;
    public Hashtable<String,Class> permisosModulo;
    
    public Long idPaquete;
    public ArrayList<Long> idsFormulario;
    public ArrayList<Long> idsPermisos;
    
    public void asignarPermisos(boolean valor,String nombrePermiso){
        //this.permisosModulo.put(nombrePermiso, valor);
    }   
    
    public void guardarPermiso(){
        
    }
    
    public void getListadoPermisos(){
        this.permisosModulo=modulo.getListadoPermisos();
    }
    
    public void verificarPaquete(String aux){
        Conexion con = Conexion.getConexion();
        JpaControllerPaquete jpaPaquete = new JpaControllerPaquete(con.getEMF());
        Class objeto = permisosModulo.get(aux);
        
        Paquete p = new Paquete();
        p.setNombre(objeto.getPackage().getName());
        
        Paquete existe = jpaPaquete.paqueteExiste(p.getNombre());
        if( existe ==null ){
            jpaPaquete.create(p);
            verificarFormulario(aux);
        } else {
            this.idPaquete=existe.getId();
            verificarFormulario(aux);
        }        
    }
    
    public void verificarFormulario(String aux){
        Conexion con = Conexion.getConexion();
        JpaControllerFormulario jpaFormulario = new JpaControllerFormulario(con.getEMF());
        
        Class objeto = permisosModulo.get(aux);
        
        Formulario f = new Formulario();
        f.setNombre(objeto.getName());
        
        Formulario existe = jpaFormulario.formularioExiste(f.getNombre());
        if( existe ==null ){
            jpaFormulario.create(f);
        }
        
        
    }
    
    public void verificarPermiso(){
        Conexion con = Conexion.getConexion();
        JpaControllerPermiso jpaPermiso = new JpaControllerPermiso(con.getEMF());
        
        ArrayList<String> permisos = new ArrayList((Collection) permisosModulo.keys());
        
        for(String aux:permisos){
            Permiso p = jpaPermiso.permisoExiste(aux);
            if(p==null){
                p.setNombre(aux);
                jpaPermiso.create(p);
                
                verificarPaquete(aux);
                
            }
        }
        
    }
    
    
}
