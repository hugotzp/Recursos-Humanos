/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@NamedQuery(name="IGSSTrabajador",query="SELECT igs FROM IGSS igs WHERE igs.Pago_idPago = :idPago")
public class IGSS implements Serializable,VariacionSalarial {
    private static final long serialVersionUID = 1L;
    final static public int pSalarioBase = 1;
    final static public int pTotal = 2;
    final static public int pHorasExtra = 3;
    @TableGenerator(
            name="secuenciaIGSS",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaIGSS")
    @Column(name="idIGSS")
    private Long id;
    private float salarioBase;
    private float horaExtra;
    public float porcentaje;
    private Long Pago_idPago;
    
    @Transient
    private float Total;
    
    public IGSS(){
        this.id = 0L;
        this.salarioBase = 0;
        this.horaExtra = 0;
        this.Total = 0;
        this.Pago_idPago = 0L;
        this.porcentaje = (float)0.283;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float getHorasExtra() {
        return horaExtra;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public float getTotal() {
        return Total;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setHorasExtra(float horasExtra) {
        this.horaExtra = horasExtra;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setTotal(float Total) {
        this.Total = Total;
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
        if (!(object instanceof IGSS)) {
            return false;
        }
        IGSS other = (IGSS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.IGSSjpa[ id=" + id + " ]";
    }
    
    @Override
    public float calcularTotal() {
        Total = (salarioBase+horaExtra) * porcentaje;
        return Total;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pSalarioBase:
                return salarioBase;
            case pTotal:
                return Total;
            case pHorasExtra:
                return horaExtra;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        calcularTotal();
        return sueldoActual - Total;
    }
    
}
