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
@NamedQuery(name="ChequeTrabajador",query="SELECT che FROM Cheque che WHERE che.Pago_idPago = :idPago")
public class Cheque implements Serializable,FormaDePago {
    private static final long serialVersionUID = 1L;
    final public static int pCuentaEmpresa = 1;
    @TableGenerator(
            name="secuenciaCheque",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaCheque")
    @Column(name="idCheque")
    private Long id;
    private String numeroCheque;
    private String cuentaEmpresa;
    private Long Pago_idPago;
    
    public Cheque(){
        numeroCheque = "";
        cuentaEmpresa = "";
        this.Pago_idPago = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public String getCuentaEmpresa() {
        return cuentaEmpresa;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public void setCuentaEmpresa(String cuentaEmpresa) {
        this.cuentaEmpresa = cuentaEmpresa;
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
        if (!(object instanceof Cheque)) {
            return false;
        }
        Cheque other = (Cheque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.Chequejpa[ id=" + id + " ]";
    }
    
    @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroCheque = numero;
    }

    @Override
    public String getNumeroDocumento() {
        return numeroCheque;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pCuentaEmpresa:
                return cuentaEmpresa;
            default:
                return null;
        }
    }
    
}
