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
    private Vector datos;
    
    public ModeloTablaPropuestas(Contratacion con){
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
        }
        return retornar;
    }
    
    public Long obtenerIdPropuesta(int row){
        return ((PropuestaEmpleo)datos.get(row)).getId();
    }
    
    class Data{
        PropuestaEmpleo propuesta;
        String Departamento;
        String Empleo;

        public Data(PropuestaEmpleo propuesta, String Departamento, String Empleo) {
            this.propuesta = propuesta;
            this.Departamento = Departamento;
            this.Empleo = Empleo;
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
        
        
    }
    
}
