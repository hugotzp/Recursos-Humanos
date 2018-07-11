/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Usuario")
public class Cliente implements Usuario, Serializable{
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaUsuario",
            allocationSize = 1,
            initialValue= 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaUsuario")
    @Column(name="idUsuario")
    private Long id;
    @Column(name="nombre")
    public String nombreUsuario;
    @Column(name="contraseña")
    public String contraseña;
    @Column(name="Rol_idRol")
    private Long idRol;
    
    @Transient
    public String rol;
    @Transient
    public AdministradorPermisos administrador;
    @Transient
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

    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    
    
    
    
    
}
