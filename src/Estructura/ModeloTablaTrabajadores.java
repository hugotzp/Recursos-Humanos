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
public class ModeloTablaTrabajadores extends AbstractTableModel {
    public String[] m_colNames = {"Nombres","Apellidos","Puesto","Salario"};
    Vector m_macDataVector;
    public ArrayList trabajadores;
    
    public ModeloTablaTrabajadores(){     
        m_macDataVector = new Vector();
    }
   
    
    public void LlenarTabla(Departamentos departamento){
        //departamento.obtenerEmpleados();
        this.trabajadores = departamento.getPersonal();
        
        m_macDataVector.setSize(0);
        for(Object aux : trabajadores){
            m_macDataVector.addElement((Trabajador) aux);
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
        Trabajador trabajador = (Trabajador) m_macDataVector.elementAt(row);
        switch(col){
            case 0:
                return trabajador.Persona.getNombre();
            case 1:
                return trabajador.Persona.getApellido();
            case 2:
                return trabajador.empleo.getNombre();
            case 3:
                return trabajador.getSalario();
            default:
                return new String();
        }
    } 
}
