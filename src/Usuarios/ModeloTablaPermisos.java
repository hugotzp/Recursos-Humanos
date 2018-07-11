/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Contratacion.ModeloTablaPropuestas;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Edwin Chocoy
 */
public class ModeloTablaPermisos extends AbstractTableModel{
    public String[] m_colNames = {"Permiso","Formulario","Acceso"};
    public Class[] clases = {String.class,String.class,Boolean.class};
    public Vector datos;

    
    public ModeloTablaPermisos(ArrayList<ValorDelPermiso> permisos,Hashtable<String,Class> permisosModulo ){
        
        this.datos= new Vector();
        
        Enumeration e = permisosModulo.keys();
        int i =0;
        while( e.hasMoreElements() ){
            
            String clave = (String) e.nextElement();
            Class objecto = permisosModulo.get(clave);
            
            
            ValorDelPermiso vp = permisos.get(i);
            
            Permisos valorPermiso = new Permisos(vp,objecto.getClass().getPackage().getName(),objecto.getName(),clave); 
            datos.add(valorPermiso);
            i++;
        }
        

    }
    @Override
    public Class getColumnClass(int column){
        return clases[column];
    }
    
    @Override
    public void setValueAt(Object value,int row, int column){
        Permisos p = (Permisos) datos.get(row);
        if(column==2){
            
            p.getValorPermiso().setAcceso((boolean) value);
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
        if(column==2){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public String getColumnName(int column){
        return m_colNames[column];
        
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Permisos p = (Permisos) datos.elementAt(row);       
        switch(col){
            case 0:
                return p.getPermiso();
            case 1:
                return p.getFormulario();
            case 2:
                return p.getValorPermiso().isAcceso();
            default:
                return new String();
        }
    }
    
    class Permisos{
        ValorDelPermiso valorPermiso;
        String paquete;
        String formulario;
        String permiso;

        public Permisos(ValorDelPermiso valorPermiso, String paquete, String formulario, String permiso) {
            this.valorPermiso = valorPermiso;
            this.paquete = paquete;
            this.formulario = formulario;
            this.permiso = permiso;
        }

        public ValorDelPermiso getValorPermiso() {
            return valorPermiso;
        }

        public String getPaquete() {
            return paquete;
        }

        public String getFormulario() {
            return formulario;
        }

        public String getPermiso() {
            return permiso;
        }

        public void setValorPermiso(ValorDelPermiso valorPermiso) {
            this.valorPermiso = valorPermiso;
        }

        public void setPaquete(String paquete) {
            this.paquete = paquete;
        }

        public void setFormulario(String formulario) {
            this.formulario = formulario;
        }

        public void setPermiso(String permiso) {
            this.permiso = permiso;
        }
        
        
 
    }
    
}
