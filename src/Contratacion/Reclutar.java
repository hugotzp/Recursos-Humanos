
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contratacion;


import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Edwin Chocoy
 */
public class Reclutar implements Reclutamiento,IterableCollection{
    
    public Date fechaContratacion;
    public Date fechaInicio;
    public Date fechaFin;
    public String Departamento;

    public ArrayList numeroFases;
    
    public ArrayList aspirantes;
    public ArrayList finalistas;
    public Puesto propuesta;
    Evaluacion evaluar;

    public Reclutar(Puesto propuesta) {
        this.fechaContratacion = new Date();
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.Departamento = "";
        this.numeroFases = new ArrayList<Integer>();
        this.propuesta = propuesta;
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

    public void setAspirantes(ArrayList aspirantes) {
        this.aspirantes = aspirantes;
    }

    public void setFinalistas(ArrayList finalistas) {
        this.finalistas = finalistas;
    }

    public void setPropuesta(Puesto propuesta) {
        this.propuesta = propuesta;
    }
    
    public void setAspirante(Aspirantes aspirante){
        this.aspirantes.add(aspirante);
    }

    public void setFinalista(Aspirantes aspirante){
        this.finalistas.add(finalistas);
    }
    
    public void reset(){
        aspirantes = new ArrayList<Aspirantes>();
        finalistas = new ArrayList<Aspirantes>();
    }
    
    

    @Override
    public void contratar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFaseReclutamiento(int numero) {
        this.numeroFases.add(numero);
    }

    @Override
    public void preseleccionarFinalistas() {
        finalistas = this.evaluar.seleccionarAspirantes();
    }

    @Override
    public Iterador obtenerFinalistas() {
        return new IteradorAspirantes(finalistas);
    }

    @Override
    public Iterador obtenerAspirantes() {
        return new IteradorAspirantes(aspirantes);
    }

    @Override
    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluar = evaluacion;
    }

    @Override
    public Iterador createIteradorFase(ArrayList fase) {
        return new IteradorAspirantes(aspirantes);
    }
    
}
