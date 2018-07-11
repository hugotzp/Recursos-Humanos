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
 * @author Edwin Chocoy
 */
public class ModeloComboBoxContratar extends ModeloComboBoxReclutamientos{
    
    ModeloTablaFasesReclutamiento tablafases;
    
    public ModeloComboBoxContratar(ArrayList<Reclutar> rec, JDateChooser fecha,ModeloTablaFasesReclutamiento tablafases) {
        super(rec, fecha);
        this.tablafases=tablafases;
        
    }
    
    @Override
    public void setSelectedItem(Object o) {
        super.setSelectedItem(o);
        tablafases.llenarTabla(this.actual);
    }
    
}
