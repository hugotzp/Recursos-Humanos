/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author Edwin Chocoy
 */
public class Cliente implements Usuario{
    
    public String nombreUsuario;
    public String contraseña;
    public String rol;
    
    public AdministradorPermisos administrador;
    
    private static Usuario usuario;
            
    private void Cliente(){
        
    }
    
    public static Usuario crearInstancia(){
        usuario= new Cliente();
        return usuario;
    }
    
    @Override
    public void login(String nombre, String contraseña) {
        this.nombreUsuario=nombre;
        this.contraseña=contraseña;
    }

    @Override
    public void setRol(String nombre) {
        this.rol=nombre;
    }

    @Override
    public String getRol() {
        return rol;
    }
    
}
