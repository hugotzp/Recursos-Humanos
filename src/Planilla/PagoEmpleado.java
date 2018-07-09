/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Conexion.Conexion;
import Estructura.AdaptadorTrabajador;
import Estructura.Trabajador;
import Estructura.Trabajadores;
import OtrasClases.IterableCollection;
import OtrasClases.Iterator;
import Planilla.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
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
import javax.persistence.Transient;

/**
 *
 * @author Hugo
 */
@Entity
@Table(name= "Pago")
@NamedQuery(name = "pagosPlanilla",query = "SELECT p FROM PagoEmpleado p WHERE p.Planilla_idPlanillaGeneral = :idPlanilla")
public class PagoEmpleado implements Serializable,PagoTrabajador,IterableCollection {
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaPago",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaPago")
    @Column(name="idPago")
    private Long id;
    @Column(name = "TotalPagado")
    private float TotalPagar;
    private int tipoPago;
    private Long Trabajador_idTrabajador;
    private Long Planilla_idPlanillaGeneral;
    
    @Transient
    private FormaDePago FormaPago;
    @Transient
    private Trabajadores Trabajador;
    @Transient
    private ArrayList<VariacionSalarial> VariacionesSalariales;

    public PagoEmpleado() {
        this.id = 0L;
        this.tipoPago = -1;
        this.TotalPagar = 0;
        this.VariacionesSalariales = new ArrayList<>();
    }

    
    public PagoEmpleado(Trabajadores Trabajador){
        this.TotalPagar = 0;
        this.Trabajador = Trabajador;
        this.VariacionesSalariales = new ArrayList<>();
        this.id = 0L;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotalPagar() {
        return TotalPagar;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public Long getTrabajador_idTrabajador() {
        return Trabajador_idTrabajador;
    }

    public Long getPlanilla_idPlanillaGeneral() {
        return Planilla_idPlanillaGeneral;
    }

    public Trabajadores getTrabajador() {
        return Trabajador;
    }

    public ArrayList<VariacionSalarial> getVariacionesSalariales() {
        return VariacionesSalariales;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setTrabajador_idTrabajador(Long Trabajador_idTrabajador) {
        this.Trabajador_idTrabajador = Trabajador_idTrabajador;
    }

    public void setPlanilla_idPlanillaGeneral(Long Planilla_idPlanillaGeneral) {
        this.Planilla_idPlanillaGeneral = Planilla_idPlanillaGeneral;
    }

    public FormaDePago getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(FormaDePago FormaPago) {
        this.FormaPago = FormaPago;
    }

    public void setTrabajador(Trabajadores Trabajador) {
        this.Trabajador = Trabajador;
    }

    public void setVariacionesSalariales(ArrayList<VariacionSalarial> VariacionesSalariales) {
        this.VariacionesSalariales = VariacionesSalariales;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoEmpleado)) {
            return false;
        }
        PagoEmpleado other = (PagoEmpleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.PagoEmpleadojpa[ id=" + id + " ]";
    }
    
     @Override
    public float getTotalAPagar() {
        return TotalPagar;
    }

    @Override
    public void setVariacionSalarial(VariacionSalarial variacion) {
        this.VariacionesSalariales.add(variacion);
    }

    @Override
    public void setEmpleado(Trabajadores empleado) {
        this.Trabajador = empleado;
    }

    @Override
    public void setTotalPagar(float total) {
        this.TotalPagar = total;
    }

    @Override
    public void calculartotalPagar() {
        float auxTotal = 0;
        //Obtener sueldo base
        auxTotal += Trabajador.getSalario();
        IteradorVariaciones lista = (IteradorVariaciones) crearIterador();
        while(lista.hasMore()){
            auxTotal = lista.getNext().modificarSalario(auxTotal);
        }
        TotalPagar = auxTotal;
    }

    @Override
    public Iterator crearIterador() {
        return new IteradorVariaciones(VariacionesSalariales);
    }

    @Override
    public void obtenerVariaciones() {
        Conexion con = Conexion.getConexion();
        //obtener Bonifiaciones
        JpaControllerBonificacion bon = new JpaControllerBonificacion(con.getEMF());
        VariacionesSalariales.addAll(bon.findBonificaciones(id));
        
        //obtenerHorasExtra
        JpaControllerHorasExtra ex = new JpaControllerHorasExtra(con.getEMF());
        VariacionesSalariales.addAll(ex.findHorasExtraTrabajador(id));
        
        //obtener Igss
        JpaControllerIGSS igss = new JpaControllerIGSS(con.getEMF());
        VariacionesSalariales.addAll(igss.findIGSSTrabajador(id));
        
        //obtener prestamo
        JpaControllerPrestamo pres = new JpaControllerPrestamo(con.getEMF());
        VariacionesSalariales.addAll(pres.findPrestamos(id));
    }

    @Override
    public void obtenerFormaPago() {
        Conexion con = Conexion.getConexion();
        switch(tipoPago){
            case 0: 
                JpaControllerEfectivo ef = new JpaControllerEfectivo(con.getEMF());
                FormaPago = ef.findFormaPago(id);
                break;
            case 1:
                JpaControllerCheque che = new JpaControllerCheque(con.getEMF());
                FormaPago = che.findFormaPago(id);
                break;
            case 2:
                JpaControllerNotaDebito not = new JpaControllerNotaDebito(con.getEMF());
                FormaPago = not.findFormaPago(id);
                break;
        }
    }

    @Override
    public void guardarBase() {
        System.out.println("tipo pago:"+ tipoPago);
        Conexion con = Conexion.getConexion();
        JpaControllerBonificacion bon = new JpaControllerBonificacion(con.getEMF());
        JpaControllerIGSS igss = new JpaControllerIGSS(con.getEMF());
        JpaControllerPrestamo pres = new JpaControllerPrestamo(con.getEMF());
        JpaControllerHorasExtra horas = new JpaControllerHorasExtra(con.getEMF());
        IteradorVariaciones iterador = (IteradorVariaciones) crearIterador();
        while(iterador.hasMore()){
            VariacionSalarial var = iterador.getNext();
            switch(var.getClass().getName()){
                case "Planilla.Bonificacion":
                    Bonificacion auxBon = (Bonificacion) var;
                    if(auxBon.getId() <= 0){
                        auxBon.setPago_idPago(id);
                        bon.create(auxBon);
                    }else{
                        try {
                            bon.edit(auxBon);
                        } catch (Exception ex) {
                            Logger.getLogger(PagoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Planilla.IGSS":
                    IGSS auxIgss = (IGSS) var;
                    if(auxIgss.getId()<=0){
                        auxIgss.setPago_idPago(id);
                        igss.create(auxIgss);
                    }else{
                        try {
                            igss.edit(auxIgss);
                        } catch (Exception ex) {
                            Logger.getLogger(PagoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Planilla.Prestamo":
                    Prestamo auxPres = (Prestamo) var;
                    if(auxPres.getId()<=0){
                        auxPres.setPago_idPago(id);
                        pres.create(auxPres);
                    }else{
                        try {
                            pres.edit(auxPres);
                        } catch (Exception ex) {
                            Logger.getLogger(PagoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Planilla.HorasExtra":
                    HorasExtra auxHoras = (HorasExtra) var;
                    if(auxHoras.getId()<=0){
                        auxHoras.setPago_idPago(id);
                        horas.create(auxHoras);
                    }else{
                        try {
                            horas.edit(auxHoras);
                        } catch (Exception ex) {
                            Logger.getLogger(PagoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }
        }
        JpaControllerEfectivo ef = new JpaControllerEfectivo(con.getEMF());
        JpaControllerCheque ch = new JpaControllerCheque(con.getEMF());
        JpaControllerNotaDebito no = new JpaControllerNotaDebito(con.getEMF());
        switch(tipoPago){
            case 0:
                ((Efectivo) FormaPago).setPago_idPago(id);
                ef.create((Efectivo) FormaPago);
                break; 
            case 1:
                ((Cheque) FormaPago).setPago_idPago(id);
                ch.create((Cheque) FormaPago);
                break;
            case 2:
                ((NotaDebito) FormaPago).setPago_idPago(id);
                no.create((NotaDebito) FormaPago);
                break;
        }
    }
    
    public void obtenerTrabajador(){
        AdaptadorTrabajador adap = new AdaptadorTrabajador();
        Trabajador a = adap.getTrabajador(Trabajador_idTrabajador);
        a.obtenerPersona();
        this.Trabajador = a;
    }

    @Override
    public void setFormaDePago(FormaDePago pago) {
        this.FormaPago = pago;
        if(pago.getClass().equals(Efectivo.class)) tipoPago = 0;
        else if(pago.getClass().equals(Cheque.class)) tipoPago =1;
        else if(pago.getClass().equals(NotaDebito.class)) tipoPago =2;
    }

    @Override
    public FormaDePago getFormaDePago() {
        return FormaPago;
    }

    @Override
    public void pagar() {
        this.calculartotalPagar();
        this.FormaPago.pagar(this.getTotalPagar());
    }

    @Override
    public Hashtable<String, ConstructorVariacionSalarial> getVariacionSalarial() {
        FabricaVariacionesSalariales fab = new FabricaVariacionesSalariales();
        ConstructorVariacionSalarial bon = fab.crearObjeto(FabricaVariacionesSalariales.bonificacion);
        bon.buildPart(ConstructorBonificacion.pValorBono,new Float(250));
        ConstructorVariacionSalarial ig = fab.crearObjeto(FabricaVariacionesSalariales.igss);
        ig.buildPart(ConstructorIgss.pSalarioBase, Trabajador.getSalario());
        ConstructorVariacionSalarial hor = fab.crearObjeto(FabricaVariacionesSalariales.horasExtra);
        hor.buildPart(ConstructorHorasExtra.pSalarioBase, Trabajador.getSalario());
        ConstructorVariacionSalarial pres = fab.crearObjeto(FabricaVariacionesSalariales.prestamo);
        this.setVariacionSalarial(bon.getVariacion());
        this.setVariacionSalarial(ig.getVariacion());
        this.setVariacionSalarial(hor.getVariacion());
        this.setVariacionSalarial(pres.getVariacion());
        Hashtable<String,ConstructorVariacionSalarial> variaciones = new Hashtable<>();
        variaciones.put(FabricaVariacionesSalariales.igss, ig);
        variaciones.put(FabricaVariacionesSalariales.bonificacion, bon);
        variaciones.put(FabricaVariacionesSalariales.horasExtra, hor);
        variaciones.put(FabricaVariacionesSalariales.prestamo, pres);
        return variaciones;
    }
    
}
