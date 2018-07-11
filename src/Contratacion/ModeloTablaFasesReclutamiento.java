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
public class ModeloTablaFasesReclutamiento extends AbstractTableModel{
    
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private Vector datos;
    
    public ModeloTablaFasesReclutamiento(){
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();
        datos = new Vector();

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
                retornar = d.isAplica();
                break;
        }
        return retornar;
    }
    
    public void setValueAt(Object value,int row, int col){
        if(col ==2){
            Data d = (Data) datos.get(row);
            d.setAplica((boolean) value);
        }
    }
    
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(col ==2){
            return true;
        }else{
            return false;
        }
    }
  
    
    
    public void llenarTabla(Reclutar reclutamiento){
        
        reclutamiento.cargarFases();
        ArrayList<FasesDeReclutamiento> fases =reclutamiento.getFasesRelacionadas();
        for(FasesDeReclutamiento aux :fases){
            aux.obtenerNombre();
            datos.add(new Data(aux,false));
        }
        fireTableStructureChanged();
        
    }
    
    public ArrayList<Integer> getFasesSeleccionadas(){
        
        ArrayList<Integer> fasesSeleccionadas = new ArrayList<Integer>();
        
        for(Object aux : datos){
            Data fase = (Data) aux;
            if(fase.isAplica()){
               fasesSeleccionadas.add(fase.getFase().getIdFaseReclutamiento().intValue());
            } 
        }
        
        
        return fasesSeleccionadas;
        
    }
    
    
    public class Data{
        private FasesDeReclutamiento fase;
        private boolean aplica;

        public Data(FasesDeReclutamiento fase, boolean aplica) {
            this.fase = fase;
            this.aplica = aplica;
        }

        public FasesDeReclutamiento getFase() {
            return fase;
        }

        public boolean isAplica() {
            return aplica;
        }

        public void setAplica(boolean aplica) {
            this.aplica = aplica;
        }
        
        
    }
}
