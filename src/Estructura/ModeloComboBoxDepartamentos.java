/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author analisis
 */
public class ModeloComboBoxDepartamentos extends AbstractListModel implements ComboBoxModel{
    
    
    public ArrayList departamentos;
    ModeloTablaTrabajadores tabla;
    Departamentos selecionado =  null;
    
    
    public ModeloComboBoxDepartamentos(ArrayList departamentos,ModeloTablaTrabajadores tabla){
        this.departamentos = departamentos;
        this.tabla = tabla;
    }
    
    @Override
    public int getSize() {
        return departamentos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return departamentos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selecionado = (Departamentos) anItem;
        tabla.LlenarTabla(selecionado);
    }

    @Override
    public Object getSelectedItem() {
        
        return selecionado;
    }

}
