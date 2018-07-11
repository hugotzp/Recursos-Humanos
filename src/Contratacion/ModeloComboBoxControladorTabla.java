/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class ModeloComboBoxControladorTabla extends ModeloComboBoxReclutamientos{
    ModeloTablaCalificaciones tabla;
    public ModeloComboBoxControladorTabla(ArrayList<Reclutar> rec, JDateChooser fecha, ModeloTablaCalificaciones mod) {
        super(rec, fecha);
        this.tabla = mod;
    }
    
    @Override
    public void setSelectedItem(Object o) {
        super.setSelectedItem(o);
        tabla.LlenarTabla(this.actual);
        
    }
    
}
