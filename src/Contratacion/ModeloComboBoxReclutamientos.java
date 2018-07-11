/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Hugo
 */
public class ModeloComboBoxReclutamientos extends AbstractListModel implements ComboBoxModel{
    ArrayList<Reclutar> reclutamientos;
    Reclutar actual;
    JDateChooser fecha;
    
    public ModeloComboBoxReclutamientos(ArrayList<Reclutar> rec, JDateChooser fecha){
        this.reclutamientos = rec;
        this.fecha = fecha;
    }

    @Override
    public int getSize() {
        return reclutamientos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return reclutamientos.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.actual = (Reclutar) o;
        this.fecha.setDate(this.actual.getFechaInicio());
    }

    @Override
    public Object getSelectedItem() {
        return actual;
    }
    
}
