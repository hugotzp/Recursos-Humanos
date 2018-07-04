/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import static Planilla.Bonificacion.pValor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 *
 * @author Hugo
 */
@Entity
@NamedQuery(name="BonificacionesTrabajador",query="SELECT bon FROM Bonificacion bon WHERE bon.Pago_idPago = :idPago")
public class Bonificacion implements Serializable,VariacionSalarial {
    private static final long serialVersionUID = 1L;
    @TableGenerator(
            name="secuenciaBonificacion",
            allocationSize = 1,
            initialValue= 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="secuenciaBonificacion")
    @Column(name="idBonificacion")
    private Long id;
    @Column(name="valor")
    private float valorBono;
    @Column(name="Pago_idPago")
    private Long Pago_idPago;
    
    final static public int pValor = 1;
    
     public Bonificacion(){
        valorBono = 0;
        Pago_idPago = 0L;
    }

    public float getValorBono() {
        return valorBono;
    }

    public Long getPago_idPago() {
        return Pago_idPago;
    }

    public static int getpValor() {
        return pValor;
    }

    public void setPago_idPago(Long Pago_idPago) {
        this.Pago_idPago = Pago_idPago;
    }
    
    
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     public void setValorBono(float valor){
        this.valorBono = valor;
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
        if (!(object instanceof Bonificacion)) {
            return false;
        }
        Bonificacion other = (Bonificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planilla.Bonificacionjpa[ id=" + id + " ]";
    }
    
    @Override
    public float calcularTotal() {
        return valorBono;
    }

    @Override
    public Object getPropiedad(int tipo) {
        switch(tipo){
            case pValor:
                return valorBono;
            default:
                return null;
        }
    }

    @Override
    public float modificarSalario(float sueldoActual) {
        return sueldoActual+valorBono;
    }
    
}
