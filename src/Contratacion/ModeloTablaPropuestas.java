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
public class ModeloTablaPropuestas extends AbstractTableModel {
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private int seleccionado;
    private Vector datos;
    
    public ModeloTablaPropuestas(Contratacion con){
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();
        seleccionado = -1;
        datos = new Vector();
        for(Object p : con.obtenerPropuestas()){
            PropuestaEmpleo pe = (PropuestaEmpleo) p;
            Data d = new Data(pe, con.obtenerDepartamento(pe.getIdDepartamento()), con.obtenerEmpleo(pe.getIdEmpleo()));
            datos.add(d);
        }
        nombreColumnas.add("No.");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Departamento");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Empleo");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Salario Propuesto");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Seleccionar");
        clasesColumnas.add(Boolean.class);
                
    }
    
    
    @Override
    public Class getColumnClass(int col){
        return clasesColumnas.get(col);
    }
    
    @Override
    public String getColumnName(int col){
        return nombreColumnas.get(col);
    }
    
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.size();
    }

   public Object getValueAt(int row, int col) {
        Object retornar = null;
        Data d = (Data) datos.get(row);
        switch(col){
            case 0:
                retornar = row +1;
                break;
            case 1:
                retornar = d.getDepartamento();
                break;
            case 2:
                retornar = d.getEmpleo();
                break;
            case 3:
                retornar = d.getPropuesta().getSalario();
                break;
            case 4:
                retornar = d.isSeleccionado();
                break;
        }
        return retornar;
    }
   
    @Override
   public void setValueAt(Object value, int row, int col){
       Data d = (Data) datos.get(row);
       if(col == 4){
           if(seleccionado != row){
               if(seleccionado>=0){
                   Data aux = (Data) datos.get(seleccionado);
                   aux.setSeleccionado(!aux.isSeleccionado());
               }
               d.setSeleccionado((boolean) value);
               seleccionado = row;
           }
       }
   }
   
   public boolean isCellEditable(int row, int col){
       if(col == 4){
           return true;
       }else{
           return false;
       }
   }
    
    public Long obtenerIdPropuesta(){
        System.out.println(((Data)datos.get(seleccionado)).getPropuesta().getId());
        return ((Data)datos.get(seleccionado)).getPropuesta().getId();
    }
    
    class Data{
        PropuestaEmpleo propuesta;
        String Departamento;
        String Empleo;
        boolean Seleccionado;

        public Data(PropuestaEmpleo propuesta, String Departamento, String Empleo) {
            this.propuesta = propuesta;
            this.Departamento = Departamento;
            this.Empleo = Empleo;
            this.Seleccionado = false;
        }

        public PropuestaEmpleo getPropuesta() {
            return propuesta;
        }

        public String getDepartamento() {
            return Departamento;
        }

        public String getEmpleo() {
            return Empleo;
        }

        public boolean isSeleccionado() {
            return Seleccionado;
        }

        public void setSeleccionado(boolean Seleccionado) {
            this.Seleccionado = Seleccionado;
        }
        
        
    }
    
}
