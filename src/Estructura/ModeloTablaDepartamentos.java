/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Hugo
 */
public class ModeloTablaDepartamentos extends AbstractTableModel {
    public String[] m_colNames = {"Nombre"};
    Vector m_macDataVector;
    public ArrayList departamentos;
    
    public ModeloTablaDepartamentos(ArrayList departamentos){
        
        this.departamentos=departamentos;       
        m_macDataVector = new Vector();
        LlenarTabla();
    }
   
    
    public void LlenarTabla(){
        
        m_macDataVector.setSize(0);
        for(Object aux : departamentos){
            m_macDataVector.addElement((Departamentos) aux);
        }
        fireTableDataChanged();
    }
    @Override
    public String getColumnName(int column){
        return m_colNames[column];
        
    }
    
    @Override
    public int getRowCount() {
        return m_macDataVector.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Departamentos dep = (Departamentos) m_macDataVector.elementAt(row);
        switch(col){
            case 0:
                return dep.getNombre();
            default:
                return new String();
        }
    } 
}
