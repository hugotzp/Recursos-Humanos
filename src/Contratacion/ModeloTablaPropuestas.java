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
    }
    
    
    
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
