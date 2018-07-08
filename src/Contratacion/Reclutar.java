
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contratacion;


import Conexion.Conexion;
import Estructura.AdaptadorContratarEmpleado;
import Estructura.JpaControllerTrabajador;
import OtrasClases.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.*;
/**
 *
 * @author Edwin Chocoy
 */
@Entity
@Table(name="Reclutamiento")
public class Reclutar implements Reclutamiento,IterableCollection,Serializable{
    
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaReclutamiento",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="secuenciaDepartamento")
    @Column(name="idDepartamento")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    public Date fechaContratacion;
    @Temporal(TemporalType.DATE)
    public Date fechaInicio;
    @Temporal(TemporalType.DATE)
    public Date fechaFin;
    
    @Column(name="Propuesta_idPropuesta")
    private Long idPropuesta;
    
    
    
    public String Departamento;
    public ArrayList numeroFases;   
    public ArrayList aspirantes;
    public ArrayList finalistas;
    public PropuestaEmpleo propuesta;
    public Evaluacion evaluar;
    

    public Reclutar() {
        this.fechaContratacion = new Date();
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.Departamento = "";
        this.numeroFases = new ArrayList<Integer>();
        
        Conexion c = Conexion.getConexion();       
        JpaControllerPropuesta p = new JpaControllerPropuesta(c.getEMF());
        AdaptadorDepartamentos d = new AdaptadorDepartamentos();
        
        this.propuesta = p.findPropuestaEmpleo(idPropuesta);
        this.Departamento = d.getDepartamento(propuesta.getIdDepartamento()).getNombre();
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public void setNumeroFases(ArrayList numeroFases) {
        this.numeroFases = numeroFases;
    }

    public void setPropuesta(PropuestaEmpleo propuesta) {
        this.propuesta = propuesta;
    }
    
    public void setAspirantes(ArrayList aspirantes) {
        this.aspirantes = aspirantes;
    }

    public void setFinalistas(ArrayList finalistas) {
        this.finalistas = finalistas;
    }

    public void setPropuesta(Puesto propuesta) {
        this.propuesta = (PropuestaEmpleo) propuesta;
    }
    
    public void setAspirante(Aspirantes aspirante){
        this.aspirantes.add(aspirante);
    }

    public void setFinalista(Aspirantes aspirante){
        this.finalistas.add(finalistas);
    }
    
    public Evaluacion getEvaluar() {
        return evaluar;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public ArrayList getNumeroFases() {
        return numeroFases;
    }

    public ArrayList getAspirantes() {
        return aspirantes;
    }

    public ArrayList getFinalistas() {
        return finalistas;
    }

    public Puesto getPropuesta() {
        return propuesta;
    }

    public void reset(){
        aspirantes = new ArrayList<Aspirantes>();
        finalistas = new ArrayList<Aspirantes>();
    }
    
    
    @Override
    public void contratar() {
        AdaptadorContratarEmpleado contratar = new AdaptadorContratarEmpleado();
        contratar.contratarEmpleado(id, idPropuesta, idPropuesta, 0);
    }

    @Override
    public void setFaseReclutamiento(int numero) {
        this.numeroFases.add(numero);
    }

    @Override
    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluar = evaluacion;
    }

    @Override
    public void cargarAspirantes() {
        Conexion c = Conexion.getConexion();
        JpaControllerAspirantes a = new JpaControllerAspirantes(c.getEMF());
        aspirantes=(ArrayList) a.findAspirantesEntities();
    }

    @Override
    public void cargarPuesto() {
        Conexion con = Conexion.getConexion();
        JpaControllerPropuesta p = new JpaControllerPropuesta(con.getEMF()); 
        propuesta=p.findPropuestaEmpleo(idPropuesta);
    }

    @Override
    public void cargarFases() {
        Conexion con = Conexion.getConexion();
        JpaControllerFasesDeReclutamiento f = new JpaControllerFasesDeReclutamiento(con.getEMF()); 
        numeroFases=f.obtenerFasesDeReclutamiento(id);
    }  
    
    @Override
    public IteradorAspirantes obtenerFinalistas() {
         return new IteradorAspirantes(finalistas);
    }

    @Override
    public IteradorAspirantes obtenerAspirantes() {
        return new IteradorAspirantes(aspirantes);
    }

    @Override
    public Iterator crearIterador() {
        return new IteradorAspirantes(aspirantes);
    }   
    
    //BD
    
    public Long getId() {
        return id;
    }

    public Long getIdPropuesta() {
        return idPropuesta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdPropuesta(Long idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

}
