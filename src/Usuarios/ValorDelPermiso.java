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
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 *
 * @author Edwin Chocoy
 */
@Entity
@NamedQuery(name="valorPermisoExiste",query="SELECT v FROM ValorDelPermiso v WHERE v.idFormulario = :idF AND v.idPermiso = :idP AND v.idRol = :idR")
public class ValorDelPermiso implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaValorPermiso",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaValorPermiso")
    @Column(name="idValorDelPermiso")
    private Long id;
    
    @Column(name="Permiso_idPermiso")
    private Long idPermiso;
    
    @Column(name="Formulario_idFormulario")
    private Long idFormulario;
    
    @Column(name="Rol_idRol")
    private Long idRol;
    
    private boolean acceso;

    public ValorDelPermiso(){
        this.id=0L;
    }
    
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
    
    @Override
    public String toString(){
        return (id.toString()+idPermiso.toString()+idRol.toString()+idFormulario.toString());
    }
    
}
