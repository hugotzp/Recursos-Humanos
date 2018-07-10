/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Estructura.Departamentos;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Hugo
 */
public class ModeloComboBoxDepartamentos extends AbstractListModel implements ComboBoxModel {
    ArrayList<Departamentos> departamentos;
    Departamentos actual;
    public ModeloComboBoxDepartamentos(ArrayList departamentos){
        this.departamentos = departamentos;
        if(departamentos.size()>0)
        this.actual = (Departamentos) departamentos.get(0);
    }
    
    @Override
    public int getSize() {
        return departamentos.size();
    }

    @Override
    public Object getElementAt(int i) {
        return departamentos.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.actual = (Departamentos) o;
    }

    @Override
    public Object getSelectedItem() {
        return this.actual;
    }
    
}
