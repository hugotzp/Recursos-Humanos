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
 * @author Hugo
 */
public class ModeloTablaSeleccionarFases extends AbstractTableModel{
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private Vector datos;
    
    public ModeloTablaSeleccionarFases(Contratacion con){
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();
        datos = new Vector();
        con.obtenerFasesReclutamientoExistentes();
        for(Object f : con.getFasesExistentes()){
            Data d = new Data((FaseReclutamiento) f, false);
            datos.add(d);
        }
        nombreColumnas.add("No");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Nombre");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Adjuntar");
        clasesColumnas.add(Boolean.class);
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
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object retornar = null;
        Data d = (Data) datos.get(row);
        switch(col){
            case 0:
                retornar = row+1;
                break;
            case 1:
                retornar = d.getFase().getNombre();
                break;
            case 2:
                retornar = d.isSeleccionado();
                break;
        }
        return retornar;
    }
    
    public void setValueAt(Object value,int row, int col){
        if(col ==2){
            Data  d = (Data) datos.get(row);
            d.setSeleccionado((boolean) value);
        }
    }
    
    public ArrayList<Long> getIdFasesSeleccionadas(){
        ArrayList<Long> idFases = new ArrayList<>();
        for(Object o : datos){
            Data d = (Data) o;
            if(d.isSeleccionado()) idFases.add(d.getFase().getId());
        }
        return idFases;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col ==2){
            return true;
        }else{
            return false;
        }
    }
    
    class Data{
        FaseReclutamiento fase;
        boolean seleccionado;

        public Data(FaseReclutamiento fase, boolean seleccionado) {
            this.fase = fase;
            this.seleccionado = seleccionado;
        }

        public FaseReclutamiento getFase() {
            return fase;
        }

        public boolean isSeleccionado() {
            return seleccionado;
        }

        public void setFase(FaseReclutamiento fase) {
            this.fase = fase;
        }

        public void setSeleccionado(boolean seleccionado) {
            this.seleccionado = seleccionado;
        }
        
        
    }
}
