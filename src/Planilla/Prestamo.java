/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.io.Serializable;
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
@NamedQuery(name="PrestamosTrabajador",query="SELECT pres FROM Prestamo pres WHERE pres.Pago_idPago = :idPago")
public class Prestamo implements Serializable,VariacionSalarial {
    private static final long serialVersionUID = 1L;
    final public static int pTotalPrestamo = 1;
    final public static int pNumeroPagos = 2;
    final public static int pTotal = 3;
    @Transient
    private float Total;
    
    @TableGenerator(
            name="secuenciaPrestamo",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaPrestamo")
    @Column(name="idPrestamo")
    private Long id;
    private float TotalPrestamo;
    private float NumeroPagos;
    private boolean Vigente;
    private Long Pago_idPago;
    
    public Prestamo(){
        this.TotalPrestamo = 0;
        this.NumeroPagos = 0;
        this.Total = 0;
        this.Vigente = false;
        this.Pago_idPago = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setPago_idPago(Long Pago_idPago) {
        this.Pago_idPago = Pago_idPago;
    }
    
    public boolean getVigente() {
        return Vigente;
    }

    public void setVigente(boolean Vigente) {
        this.Vigente = Vigente;
    }
    
    public void setTotalPrestamo(float total){
        this.TotalPrestamo = total;
    }
    
    public void setNumeroPagos(float total){
        this.NumeroPagos = total;
    }

    public float getTotalPrestamo() {
        return TotalPrestamo;
    }

    public float getNumeroPagos() {
        return NumeroPagos;
    }

    public float getTotal() {
        return Total;
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
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.Prestamojpa[ id=" + id + " ]";
    }
    
    @Override
    public float calcularTotal() {
        float totalAPagar=0;
        totalAPagar = TotalPrestamo / NumeroPagos;
        Total = totalAPagar;
        return totalAPagar;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pNumeroPagos:
                return NumeroPagos;
            case pTotal:
                return Total;
            case pTotalPrestamo:
                return TotalPrestamo;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        return sueldoActual - calcularTotal();
    }
    
}
