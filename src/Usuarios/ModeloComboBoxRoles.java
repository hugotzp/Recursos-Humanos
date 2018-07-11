/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Edwin Chocoy
 */
public class ModeloComboBoxRoles extends AbstractListModel implements ComboBoxModel{
    
    ArrayList<Rol> roles;
    Rol actual;
    public ModeloComboBoxRoles(ArrayList roles){
        this.roles = roles;
        if(roles.size()>0)
        this.actual = (Rol) roles.get(0);
    }
    
    @Override
    public int getSize() {
        return roles.size();
    }

    @Override
    public Object getElementAt(int i) {
        return roles.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        this.actual = (Rol) o;
    }

    @Override
    public Object getSelectedItem() {
        return this.actual;
    }
}
