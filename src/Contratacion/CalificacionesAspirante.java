
package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name= "CalificacionesAspirante")
@NamedQuery(name="obtenerCalificaciones",query="SELECT cal FROM CalificacionesAspirante cal WHERE cal.idAspiranteAsociado =:idAspirante")
public class CalificacionesAspirante implements Calificacion,Serializable{
    
    public final static int pNumeroFase =1;
    public final static int pNombreFase =2;
    public final static int pFechaInicio = 3;
    public final static int pFechaFin = 4;
    public final static int pDesempeño = 5;
    
    @TableGenerator(
            name="secuenciaCalificacionesAspirante",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaCalificacionesAspirante")
    @Column(name="idCalificacionesAspirante")
    private Long id;
    @Column(name="Aspirante_idAspirante")
    private Long idAspiranteAsociado;
    @Column(name = "FaseReclutamiento_idFaseReclutamiento")
    private Long idFase;
    public int numeroFase;
    @Transient
    public String nombreFase;
    @Temporal(TemporalType.DATE)
    public Date fechaInicio;
    @Temporal(TemporalType.DATE)
    public Date fechaFin;
    public int desempeño;
    
    public CalificacionesAspirante(){
        id = 0L;
        idAspiranteAsociado = 0L;
        idFase = 0L;
        fechaFin = new Date();
        fechaInicio = new Date();
    }

    public Long getIdAspiranteAsociado() {
        return idAspiranteAsociado;
    }

    public void setIdAspiranteAsociado(Long idAspiranteAsociado) {
        this.idAspiranteAsociado = idAspiranteAsociado;
    }

    public void setIdFase(Long idFase) {
        this.idFase = idFase;
    }

    public Long getIdFase() {
        return idFase;
    }

    public int getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(int desempeño) {
        this.desempeño = desempeño;
    }
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
        Object retornar = null;
        switch(tipo){
            case pDesempeño:
                retornar = this.desempeño;
                break;
            case pFechaFin:
                retornar = this.fechaFin;
                break;
            case pFechaInicio:
                retornar = this.fechaInicio;
                break;
            case pNombreFase:
                retornar = this.nombreFase;
                break;
            case pNumeroFase:
                retornar = this.numeroFase;
                break;
        }
        return retornar;
    }
    
    public void obtenerDatosBae(){
        
    }

    

    @Override
    public void setNombreFase(String nombre) {
        this.nombreFase = nombre;
    }

    @Override
    public String getNombreFase() {
        return this.nombreFase;
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
