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

/**
 *
 * @author Hugo
 */
@Entity
@NamedQuery(name="EfectivoTrabajador",query="SELECT efe FROM Efectivo efe WHERE efe.Pago_idPago = :idPago")
public class Efectivo implements Serializable,FormaDePago {
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaEfectivo",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaEfectivo")
    @Column(name="idEfectivo")
    private Long id;
    private String numeroBoleta;
    private Long Pago_idPago;
    
    public Efectivo(){
        this.numeroBoleta = "";
        this.Pago_idPago = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBoleta() {
        return numeroBoleta;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setNumeroBoleta(String numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
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
        if (!(object instanceof Efectivo)) {
            return false;
        }
        Efectivo other = (Efectivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.Efectivojpa[ id=" + id + " ]";
    }
    
     @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroBoleta =  numero;
    }

    @Override
    public String getNumeroDocumento() {
        return this.numeroBoleta;
    }

    @Override
    public Object getPropiedad(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
