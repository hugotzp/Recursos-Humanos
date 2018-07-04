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
 * @author Hugo
 */
@Entity
@Table(name= "Pago")
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
    private Empleo Trabajador;
    @Transient
    private ArrayList<VariacionSalarial> VariacionesSalariales;

    public PagoEmpleado() {
    }

    
    public PagoEmpleado(FormaDePago pago,Empleo Trabajador){
        this.TotalPagar = 0;
        this.FormaPago = pago;
        this.Trabajador = Trabajador;
        this.VariacionesSalariales = new ArrayList<>();
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

    public Empleo getTrabajador() {
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

    public void setTrabajador(Empleo Trabajador) {
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
    public void setEmpleado(Empleo empleado) {
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
        //auxTotal += Trabajador.getSueldo();
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
                    auxBon.setPago_idPago(id);
                    bon.create(auxBon);
                    break;
                case "Planilla.IGSS":
                    IGSS auxIgss = (IGSS) var;
                    auxIgss.setPago_idPago(id);
                    igss.create(auxIgss);
                    break;
                case "Planilla.Prestamo":
                    Prestamo auxPres = (Prestamo) var;
                    auxPres.setPago_idPago(id);
                    pres.create(auxPres);
                    break;
                case "Planilla.HorasExtra":
                    HorasExtra auxHoras = (HorasExtra) var;
                    auxHoras.setPago_idPago(id);
                    horas.create(auxHoras);
                    break;
            }
        }
    }
    
}
