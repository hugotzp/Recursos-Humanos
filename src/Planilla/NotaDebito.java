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
@NamedQuery(name="NotaDebitoTrabajador",query="SELECT nota FROM NotaDebito nota WHERE nota.Pago_idPago = :idPago")
public class NotaDebito implements Serializable,FormaDePago {
    private static final long serialVersionUID = 1L;
    final public static int pCuentaEmpresa = 1;
    final public static int pCuentaEmpleado = 2;
    @TableGenerator(
            name="secuenciaNotaDebito",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaNotaDebito")
    @Column(name="idNotaDebito")
    private Long id;
    private String cuentaEmpresa;
    private String cuentaEmpleado;
    private String numeroNota;
    private Long Pago_idPago;
    
    public NotaDebito(){
        this.cuentaEmpresa = "";
        this.cuentaEmpleado = "";
        this.numeroNota = "";
        this.Pago_idPago = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuentaEmpresa() {
        return cuentaEmpresa;
    }

    public String getCuentaEmpleado() {
        return cuentaEmpleado;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public void setCuentaEmpresa(String cuentaEmpresa) {
        this.cuentaEmpresa = cuentaEmpresa;
    }

    public void setCuentaEmpleado(String cuentaEmpleado) {
        this.cuentaEmpleado = cuentaEmpleado;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
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
        if (!(object instanceof NotaDebito)) {
            return false;
        }
        NotaDebito other = (NotaDebito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.NotaDebitojpa[ id=" + id + " ]";
    }
    
    @Override
    public boolean pagar(float TotalPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numero) {
        this.numeroNota = numero;
    }

    @Override
    public String getNumeroDocumento() {
        return this.numeroNota;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pCuentaEmpresa:
                return cuentaEmpresa;
            case pCuentaEmpleado:
                return cuentaEmpleado;
            default:
                return null;
        }
    }
    
}
