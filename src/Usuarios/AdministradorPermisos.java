/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Conexion.Conexion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

/**
 *
 * @author Edwin Chocoy
 */
public class AdministradorPermisos {
    
    public AdaptadorPermisos modulo;
    public PermisosModulo permisosM;
    private Hashtable<String,Class> permisosModulo; //permisos de un modulo
    
    private Long idPaquete;
    private Long idRol;
    private ArrayList<FormularioPermiso> idsF_idsP = new ArrayList<FormularioPermiso>(); // relacion entre el id de Formulario y el id de Permiso
    private ArrayList<ValorDelPermiso> valorPermiso = new ArrayList<ValorDelPermiso>(); // arraylist de valordelpermiso con todos los permisos existentes o no en bd

    public Hashtable<String, Class> getPermisosModulo() {
        return permisosModulo;
    }
    
    public ArrayList getValorPermiso(){
        return valorPermiso;
    }

    public Long getIdRol() {
        return idRol;
    }
    
    public void setPermisosModulo(Hashtable<String, Class> permisosModulo) {
        this.permisosModulo = permisosModulo;
    }
    
    public void setValorPermiso(ArrayList v){
        this.valorPermiso=v;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    
    
    
    public void asignarPermisos(boolean valor,String nombrePermiso){
        //this.permisosModulo.put(nombrePermiso, valor);
    }   
    
    public void getListadoPermisos(){
        this.permisosModulo=modulo.getListadoPermisos();
    }
    
    
    public void verificarPaquete(){
        
        Conexion con = Conexion.getConexion();
        JpaControllerPaquete jpaPaquete = new JpaControllerPaquete(con.getEMF());
        
        Enumeration e = permisosModulo.keys();
        String clave = (String) e.nextElement();
        
        Class objeto = permisosModulo.get(clave);
        
        Paquete p = new Paquete();
        p.setNombre(objeto.getPackage().getName());
        
        Paquete existe = jpaPaquete.paqueteExiste(p.getNombre());
        if( existe ==null ){
            jpaPaquete.create(p);
            this.idPaquete=p.getId();
            verificarPermiso();
        } else {
            this.idPaquete=existe.getId(); 
            verificarPermiso();
        }        
    }
    
    public void verificarFormulario(String clave,Long idPermiso){
        Conexion con = Conexion.getConexion();
        JpaControllerFormulario jpaFormulario = new JpaControllerFormulario(con.getEMF());
        
        Class objeto = permisosModulo.get(clave);
        
        Formulario f = new Formulario();
        f.setNombre(objeto.getName());
        f.setIdPaquete(idPaquete);
        
        Formulario existe = jpaFormulario.formularioExiste(f.getNombre());
        if( existe ==null ){
            existe = new Formulario();
            jpaFormulario.create(f);
            FormularioPermiso f_p = new FormularioPermiso(idPermiso,f.getId());
            idsF_idsP.add(f_p);
        }
        else{
            FormularioPermiso f_p = new FormularioPermiso(idPermiso,existe.getId());
            idsF_idsP.add(f_p);
        }
   
    }
    
    public void verificarPermiso(){
        Conexion con = Conexion.getConexion();
        JpaControllerPermiso jpaPermiso = new JpaControllerPermiso(con.getEMF());
        Set<String> keySet = permisosModulo.keySet();
        ArrayList<String> permisos = new ArrayList<String>(keySet);
        
        for(String aux:permisos){
            Permiso p = jpaPermiso.permisoExiste(aux);
            if(p==null){
                p = new Permiso();
                p.setNombre(aux);
                jpaPermiso.create(p);                
                verificarFormulario(aux,p.getId());
            }
            else{
                verificarFormulario(aux,p.getId());
            }
            
        }
        
    }
    
    public void verificarValorPermiso(){
        
        Conexion con = Conexion.getConexion();
        JpaControllerValorDelPermiso jpaVP= new JpaControllerValorDelPermiso(con.getEMF());
        
        for(FormularioPermiso aux:idsF_idsP){
            ValorDelPermiso vp = jpaVP.existe(aux.getIdFormulario(),aux.getIdPermiso(), idRol);          
            if(vp==null){
                vp = new ValorDelPermiso();
                vp.setIdFormulario(aux.getIdFormulario());
                vp.setIdPermiso(aux.getIdPermiso());
                vp.setIdRol(idRol);
                vp.setAcceso(false);                
                valorPermiso.add(vp);
            }
            else{
                valorPermiso.add(vp);
            }
        }        
   
    }
    
    public void guardarPermisos() throws Exception{
        Conexion con = Conexion.getConexion();
        JpaControllerValorDelPermiso jpaVP= new JpaControllerValorDelPermiso(con.getEMF());
        
        for(ValorDelPermiso aux:valorPermiso){
            if(aux.getId()<=0){
                jpaVP.create(aux);
            }
            else{
                jpaVP.edit(aux);
            }
        }
        
    }
    
 
    class FormularioPermiso{
        
        private Long idFormulario;
        private Long idPermiso;
        
        public FormularioPermiso(Long idP,Long idF){
            this.idFormulario=idF;
            this.idPermiso=idP;
        }

        public Long getIdFormulario() {
            return idFormulario;
        }

        public Long getIdPermiso() {
            return idPermiso;
        }
        
        @Override
        public String toString() {
            return (idPermiso+"-"+idFormulario);
        }
        
        
        
    }
    
    
}
