
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 *
 * @author Edwin Chocoy
 */
@Entity
@NamedQuery(name="obtenerCalificaciones",query="SELECT c FROM CalificacionesAspirantes c WHERE c.idAspirante = :id")
public class CalificacionesAspirantes implements Calificacion,MetodosConstructorFases,Serializable{

    @Id
    private Long id;
    private Long idAspirante;
    public int numeroFase;
    public Date fechaInicio;
    public Date fechaFin;
    public int desempeño;

    @Override
    public void setNumeroFase(int fase) {
        this.numeroFase=fase;
    }


    @Override
    public void setPuntuacionDesempeño(int valor) {
        this.desempeño=valor;
    }

    @Override
    public void setFechaInicio(Date fecha) {
        this.fechaInicio=fecha;
    }

    @Override
    public void setFechaFin(Date fecha) {
        this.fechaFin=fecha;
    }

    @Override
    public int getNumeroFase() {
        return numeroFase;
    }

    @Override
    public int getPuntuacionDesempeño() {
        return desempeño;
    }

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public Object getPropiedad(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPropiedades(Hashtable datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
