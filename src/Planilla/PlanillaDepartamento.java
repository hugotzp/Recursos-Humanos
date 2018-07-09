/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;


import Conexion.Conexion;
import OtrasClases.IterableCollection;
import OtrasClases.Iterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Hugo
 */
@Entity
@Table(name = "Planilla")
@NamedQuery(name="encontrarPlanilla",query="SELECT p FROM PlanillaDepartamento p WHERE EXTRACT( MONTH from p.fecha) = EXTRACT(MONTH from :pMes) AND p.Departamento_idDepartamento = :idDepartamento")
public class PlanillaDepartamento implements PlanillaAreaTrabajo,IterableCollection, Serializable{
    
    @TableGenerator(
            name="secuenciaPlanilla",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaPlanilla")
    @Column(name="idPlanillaGeneral")
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Long Departamento_idDepartamento;
    
    @Transient
    private ArrayList<PagoTrabajador> Trabajadores;
    @Transient
    private String nombreSector;

    public PlanillaDepartamento() {
        this.id = 0L;
        this.fecha = new Date();
        this.nombreSector = "";
        this.Departamento_idDepartamento = 0L;
        this.Trabajadores = new ArrayList<>();
    }
    
    public PlanillaDepartamento(String nombre,Long idDepartamento){
        this.id = 0L;
        this.fecha = new Date();
        this.nombreSector = nombre;
        this.Departamento_idDepartamento = idDepartamento;
        this.Trabajadores = new ArrayList<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public Long getDepartamento_idDepartamento() {
        return Departamento_idDepartamento;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDepartamento_idDepartamento(Long Departamento_idDepartamento) {
        this.Departamento_idDepartamento = Departamento_idDepartamento;
    }

    public Long getId() {
        return id;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public ArrayList<PagoTrabajador> getTrabajadores() {
        return Trabajadores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public void setTrabajadores(ArrayList<PagoTrabajador> Trabajadores) {
        this.Trabajadores = Trabajadores;
    }
    
    
    @Override
    public void setPagoTrabajador(PagoTrabajador trabajador) {
        this.Trabajadores.add(trabajador);
    }

    @Override
    public ArrayList<PagoTrabajador> getPagoTrabajadores() {
        return this.Trabajadores;
    }

    @Override
    public float obtenerTotalPagoPlanilla() {
        IteradorPlanilla planilla = (IteradorPlanilla) crearIterador();
        float Total=0;
        while(planilla.hasMore()){
            Total += planilla.getNext().getTotalAPagar();
        }
        return Total;
    }

    @Override
    public Iterator crearIterador() {
        return new IteradorPlanilla(Trabajadores);
    }

    @Override
    public void guardar() {
        Conexion con = Conexion.getConexion();
        JpaControllerPago auxPago = new JpaControllerPago(con.getEMF());
        IteradorPlanilla iterador = (IteradorPlanilla) crearIterador();
        while(iterador.hasMore()){
            PagoEmpleado pago = (PagoEmpleado) iterador.getNext();
            pago.setPlanilla_idPlanillaGeneral(id);
            if(pago.getId()<=0){
                auxPago.create(pago);
                pago.guardarBase();
            }else{
                try {
                    pago.guardarBase();
                    auxPago.edit(pago);
                } catch (Exception ex) {
                    Logger.getLogger(PlanillaDepartamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void obtenerPagosPlanilla() {
        Conexion con = Conexion.getConexion();
        JpaControllerPago pagos = new JpaControllerPago(con.getEMF());
        List<PagoEmpleado> lista = pagos.findPagosPlanilla(id);
        for(PagoEmpleado pago : lista){
            pago.obtenerVariaciones();
            pago.obtenerFormaPago();
            pago.obtenerTrabajador();
        }
        Trabajadores.addAll(lista);
    }
}
