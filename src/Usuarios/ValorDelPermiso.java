/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
public class ValorDelPermiso implements Serializable {

    @Id
    private Long id;

    private static final long serialVersionUID = 1L;

    
    @Column(name="idPermiso")
    private Long idPermiso;
    
    @Column(name="idFormulario")
    private Long idFormulario;
    
    @Column(name="idRol")
    private Long idRol;
    
    private boolean acceso;

    public Long getIdPermiso() {
        return idPermiso;
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public Long getIdRol() {
        return idRol;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
