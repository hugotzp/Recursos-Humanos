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
public interface Usuario {
    
    public void login(String nombre,String contraseña);
    
    public void setRol(String nombre);
    
    public String getRol();
    
}
