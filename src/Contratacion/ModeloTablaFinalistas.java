/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Edwin Chocoy
 */
public class ModeloTablaFinalistas extends AbstractTableModel{
    
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private int id;
    
    private ArrayList<Aspirantes> aspirantes;
    
    public ModeloTablaFinalistas(Reclutar reclutamiento){
        
        this.aspirantes=reclutamiento.obtenerFinalistas().aspirantes;
        
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();

        nombreColumnas.add("Nombre");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Apellido");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Telefono");
        clasesColumnas.add(String.class);
    }
    
    @Override
    public String getColumnName(int col){
        return nombreColumnas.get(col);
    }
    
    @Override
    public Class getColumnClass(int col){
        return clasesColumnas.get(col);
    }
    
    @Override
    public int getRowCount() {
        return aspirantes.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        switch(columnIndex){
            case 0:
                return aspirantes.get(rowIndex).getPersona().getNombre();
            case 1:
                return aspirantes.get(rowIndex).getPersona().getApellido();
            case 2:
                return aspirantes.get(rowIndex).getPersona().getNumeroTelefonico();
            default:
                return new String();
        }
        
    }
    
    public Long getIdPersona(int index){
        return aspirantes.get(index).getIdPersona();
    }
     
}
