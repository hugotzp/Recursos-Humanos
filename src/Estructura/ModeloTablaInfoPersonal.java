/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Personas.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Hugo
 */
public class ModeloTablaInfoPersonal extends AbstractTableModel {
    public String[] m_colNames = {"Nombres","Apellidos","DPI","Genero","Fecha Nacimiento","Telefono"};
    Vector m_macDataVector;
    public ArrayList<Departamentos> departamentos;
    
    public ModeloTablaInfoPersonal(ArrayList departamentos){
        
        this.departamentos=departamentos;        
        m_macDataVector = new Vector();
        LlenarTabla();
    }
   
    
    public void LlenarTabla(){
        
        ArrayList<Trabajadores> trabajadores;
        m_macDataVector.setSize(0);
        for(int i=0;i<departamentos.size();i++){
            trabajadores=departamentos.get(i).getPersonal();
            for(int j=0;j<trabajadores.size();j++){
                m_macDataVector.addElement( (Personal) trabajadores.get(j).getPersona() );
            }  
        }   
        fireTableDataChanged();
    }
    
    public void informacionUnica(int dep,int trabajador){ 
        ArrayList<Trabajadores> trabajadores =departamentos.get(dep).getPersonal();
        System.out.println(trabajadores);
        m_macDataVector.setSize(0);
        m_macDataVector.addElement( (Personal) trabajadores.get(trabajador).getPersona() );
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
        Personal dep = (Personal) m_macDataVector.elementAt(row);
        switch(col){
            case 0:
                return dep.getNombre();
            case 1:
                return dep.getApellido();
            case 2:
                return dep.getDPI();
            case 3:
                if(dep.getGenero()==false){
                    return "Femenino";
                }
                else{
                    return "Masculino";
                }               
            case 4:
                return dep.getFechaNacimiento();
            case 5:
                return dep.getTelefono();
            default:
                return new String();
        }
    } 
}
