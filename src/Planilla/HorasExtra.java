/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author Hugo
 */
@Entity
@NamedQuery(name="HorasExtraTrabajador",query="SELECT hora FROM HorasExtra hora WHERE hora.Pago_idPago = :idPago")
public class HorasExtra implements Serializable,VariacionSalarial {
    private static final long serialVersionUID = 1L;
    final public static int pNumeroHorasExtra = 1;
    final public static int pSalarioBase = 2;
    final public static int pTotal = 3;
    @Transient
    float total;
    
    @TableGenerator(
            name="secuenciaHorasExtra",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaHorasExtra")
    @Column(name="idHorasExtra")
    private Long id;
    float numeroHorasExtra;
    float salarioBase;
    float porcentajeHoraExtra = (float)1.5;
    float totalHorasLaboradas = 8;
    private Long Pago_idPago;
    
    public HorasExtra(){
        this.numeroHorasExtra = 0;
        this.salarioBase = 0;
        this.total = 0;
        Pago_idPago = 0L;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public float getNumeroHorasExtra() {
        return numeroHorasExtra;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float getPorcentajeHoraExtra() {
        return porcentajeHoraExtra;
    }

    public float getTotalHorasLaboradas() {
        return totalHorasLaboradas;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setNumeroHorasExtra(float numeroHorasExtra) {
        this.numeroHorasExtra = numeroHorasExtra;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setPorcentajeHoraExtra(float porcentajeHoraExtra) {
        porcentajeHoraExtra = porcentajeHoraExtra;
    }

    public void setTotalHorasLaboradas(float totalHorasLaboradas) {
        totalHorasLaboradas = totalHorasLaboradas;
    }

    public void setPago_idPago(Long Pago_idPago) {
        this.Pago_idPago = Pago_idPago;
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
        if (!(object instanceof HorasExtra)) {
            return false;
        }
        HorasExtra other = (HorasExtra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.HorasExtrajpa[ id=" + id + " ]";
    }
    
    @Override
    public float calcularTotal() {
        Calendar fecha = new GregorianCalendar();
        float diasTotales = 0;
        if(fecha.getActualMaximum(Calendar.DAY_OF_MONTH)<=30) diasTotales = 30;
        else diasTotales = 31;
        float pagoPorHora = (salarioBase/diasTotales)/totalHorasLaboradas;
        total = numeroHorasExtra * pagoPorHora;
        return total;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pNumeroHorasExtra:
                return numeroHorasExtra;
            case pSalarioBase:
                return salarioBase;
            case pTotal:
                return total;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        calcularTotal();
        return sueldoActual + total;
    }
    
}
