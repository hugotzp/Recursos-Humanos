/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import OtrasClases.Iterator;
import Personas.Persona;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hugo
 */
public class ModeloTablaPagarPlanilla extends AbstractTableModel{
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private Vector datos;
    
    public ModeloTablaPagarPlanilla(PlanillaEmpresa empresa){
        super();
        datos = new Vector();
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();
        nombreColumnas.add("No.");//0
        clasesColumnas.add(String.class);
        nombreColumnas.add("Nombre");//1
        clasesColumnas.add(String.class);
        nombreColumnas.add("Departamento");//2
        clasesColumnas.add(String.class);
        nombreColumnas.add("Puesto");//3
        clasesColumnas.add(String.class);
        nombreColumnas.add("Total a Pagar");//4
        clasesColumnas.add(String.class);
        nombreColumnas.add("Forma Pago");
        clasesColumnas.add(JComboBox.class);
        nombreColumnas.add("Numero documento");//6
        clasesColumnas.add(String.class);
        nombreColumnas.add("Cuenta Empleado");//7
        clasesColumnas.add(String.class);
        nombreColumnas.add("Cuenta Empresa");//8
        clasesColumnas.add(String.class);
        empresa.obtenerPlanillaBase();
        for(PlanillaAreaTrabajo p : empresa.getPlanillas()){
            for(PagoTrabajador pago : p.getPagoTrabajadores()){
                Data empleado = new Data((PagoEmpleado) pago);
                empleado.setDepartamento(((PlanillaDepartamento)p).getNombreSector());
                datos.add(empleado);
            }
        }
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
        Data clase = (Data) datos.get(row);
        switch(col){
            case 0:
                retornar = row +1;
                break;
            case 1:
                Persona a = clase.getPago().getTrabajador().getPersona(); 
                retornar = a.getNombre()+a.getApellido();
                break;
            case 2:
                retornar = clase.getDepartamento();
                break;
            case 3:
                retornar = clase.getPago().getTrabajador().getNombreEmpleo();
                break;
            case 4:
                clase.getPago().calculartotalPagar();
                retornar = clase.getPago().getTotalPagar();
                break;
            case 5:
                retornar = clase.getFormaPago();
                break;
            case 6:
                retornar = clase.getDocumento();
                break;
            case 7:
                retornar =clase.getCuentaEmpleado();
                break;
            case 8:
                retornar = clase.getCuentaEmpresa();
                break;
        }
        return retornar;
    }
    
    @Override
    public void setValueAt(Object value,int row,int col){
        Data clase = (Data) datos.get(row);
        switch(col){
            case 5:
                clase.setFormaPago((String) value);
                break;
            case 6:
                clase.setDocumento((String) value);
                break;
            case 7:
                clase.setCuentaEmpleado((String) value);
                break;
            case 8:
                clase.setCuentaEmpresa((String) value);
                break;
        }
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
    public boolean isCellEditable(int row,int col){
        if(col== 5 || col== 6 || col== 7 || col== 8 ) return true;
        else return false;
    }
    
    public boolean guardarPagos(){
        java.util.Iterator i = datos.iterator();
        FabricaFormaDePago fabrica = new FabricaFormaDePago();
        while(i.hasNext()){
            Data d = (Data) i.next();
            switch(d.getFormaPago()){
                case "Efectivo":
                    ConstructorFormaDePago ef = fabrica.crearObjeto(FabricaFormaDePago.efectivo);
                    if(d.getDocumento().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado documento");
                        return false;
                    }
                    ef.buildPart(ConstructorEfectivo.pNumeroBoleta, d.getDocumento());
                    d.getPago().setFormaDePago(ef.getFormaPago());
                    break;
                case "Cheque":
                    ConstructorFormaDePago ch = fabrica.crearObjeto(FabricaFormaDePago.cheque);
                    if(d.getDocumento().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado documento");
                        return false;
                    }
                    if(d.getCuentaEmpresa().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado cuenta empresa");
                        return false;
                    }
                    ch.buildPart(ConstructorCheque.pNumeroCheque, d.getDocumento());
                    ch.buildPart(ConstructorCheque.pCuentaEmpresa, d.getCuentaEmpresa());
                    d.getPago().setFormaDePago(ch.getFormaPago());
                    break;
                case "Nota Debito":
                    ConstructorFormaDePago no = fabrica.crearObjeto(FabricaFormaDePago.notadebito);
                    if(d.getDocumento().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado documento");
                        return false;
                    }
                    if(d.getCuentaEmpresa().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado cuenta empresa");
                        return false;
                    }
                    if(d.getCuentaEmpleado().length()<=0){
                        JOptionPane.showInputDialog("No ha ingresado cuenta empleado");
                        return false;
                    }
                    no.buildPart(ConstructorNotaDebito.pNumeroNota, d.getDocumento());
                    no.buildPart(ConstructorNotaDebito.pCuentaEmpresa, d.getCuentaEmpresa());
                    no.buildPart(ConstructorNotaDebito.pCuentaEmpleado, d.getCuentaEmpleado());
                    d.getPago().setFormaDePago(no.getFormaPago());
                    break;
            }
        }
        return true;
    }
    
    class Data{
        PagoEmpleado pago;
        String documento ;
        String cuentaEmpresa;
        String cuentaEmpleado;
        String departamento;
        String FormaPago;

        public Data(PagoEmpleado pago) {
            this.pago = pago;
            this.FormaPago = "Efectivo";
            this.documento = "";
            this.cuentaEmpresa = "";
            this.cuentaEmpleado = "";
            this.departamento = "";
        }

        public PagoEmpleado getPago() {
            return pago;
        }

        public String getFormaPago() {
            return FormaPago;
        }

        public String getDocumento() {
            return documento;
        }

        public String getCuentaEmpresa() {
            return cuentaEmpresa;
        }

        public String getCuentaEmpleado() {
            return cuentaEmpleado;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public void setCuentaEmpresa(String cuentaEmpresa) {
            this.cuentaEmpresa = cuentaEmpresa;
        }

        public void setCuentaEmpleado(String cuentaEmpleado) {
            this.cuentaEmpleado = cuentaEmpleado;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }
        
        public void setFormaPago(String pago){
            this.FormaPago = pago;
        }
        
        
    }
     
}
