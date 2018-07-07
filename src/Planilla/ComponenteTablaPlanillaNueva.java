/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import Estructura.Organizacion;
import Personas.Persona;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hugo
 */
public class ComponenteTablaPlanillaNueva extends AbstractTableModel {
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private Vector datos;
    
    public ComponenteTablaPlanillaNueva(){
        super();
        datos = new Vector();
        PlanillaEmpresa empresa = new PlanillaEmpresa();
        empresa.setAdaptadorDepartamentos(new Organizacion());
        empresa.crearNuevaPlanillaEmpresa();
        nombreColumnas = new ArrayList<>();
        clasesColumnas = new ArrayList<>();
        nombreColumnas.add("No.");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Nombre");
        clasesColumnas.add(String.class);
        nombreColumnas.add("DPI");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Departamento");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Puesto");
        clasesColumnas.add(String.class);
        nombreColumnas.add("Sueldo Base");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Bonificacion");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Cantidad Horas Extras");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Total Horas Extra");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("IGSS");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Valor Prestamo");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Numero Pagos");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Pago Prestamo");
        clasesColumnas.add(Float.class);
        nombreColumnas.add("Total Pagar");
        clasesColumnas.add(Float.class);
        
        
        for(PlanillaAreaTrabajo p : empresa.getPlanillas()){
            for(PagoTrabajador pago : p.getPagoTrabajadores()){
                Data empleado = new Data(pago,pago.getVariacionSalarial(),((PlanillaDepartamento)p).getNombreSector());
                System.out.println("entro");
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
        Data dato = (Data) datos.elementAt(row);
        switch(col){
            case 0:
                retornar = row+1;
                break;
            case 1:
                retornar = dato.getEmpleado().getNombre()+" "+dato.getEmpleado().getApellido();
                break;
            case 2:
                retornar = dato.getEmpleado().getDPI();
                break;
            case 3:
                retornar = dato.getDepartamento();
                break;
            case 4:
                retornar = dato.getPuesto();
                break;
            case 5:
                retornar = dato.getSueldoBase();
                break;
            case 6:
                retornar = dato.getDato(FabricaVariacionesSalariales.bonificacion).getVariacion().calcularTotal();
                break;
            case 7:
                retornar = dato.getDato(FabricaVariacionesSalariales.horasExtra).getVariacion().getPropiedad(HorasExtra.pNumeroHorasExtra);
                break;
            case 8:
                retornar = dato.getDato(FabricaVariacionesSalariales.horasExtra).getVariacion().calcularTotal();
                break;
            case 9:
                retornar = dato.getDato(FabricaVariacionesSalariales.igss).getVariacion().calcularTotal();
                break;
            case 10:
                retornar = dato.getDato(FabricaVariacionesSalariales.prestamo).getVariacion().getPropiedad(Prestamo.pTotalPrestamo);
                break;
            case 11:
                retornar = dato.getDato(FabricaVariacionesSalariales.prestamo).getVariacion().getPropiedad(Prestamo.pNumeroPagos);
                break;
            case 12:
                retornar = dato.getDato(FabricaVariacionesSalariales.prestamo).getVariacion().calcularTotal();
                break;
            case 13:
                retornar = dato.getTotalPagar();
                break;
        }
        return retornar;
    }
    
    @Override
    public void setValueAt(Object value,int row, int col) {
        Data dato = (Data) datos.elementAt(row);
        switch(col){
            case 6:
                dato.getDato(FabricaVariacionesSalariales.bonificacion).buildPart(Bonificacion.pValor, value);
                break;
            case 7:
                dato.getDato(FabricaVariacionesSalariales.horasExtra).buildPart(HorasExtra.pNumeroHorasExtra, value);
                dato.getDato(FabricaVariacionesSalariales.igss).buildPart(IGSS.pHorasExtra, dato.getDato(FabricaVariacionesSalariales.horasExtra).getVariacion().calcularTotal());
                break;
            case 10:
                dato.getDato(FabricaVariacionesSalariales.prestamo).buildPart(Prestamo.pTotalPrestamo, value);
                break;
            case 11:
                dato.getDato(FabricaVariacionesSalariales.prestamo).buildPart(Prestamo.pNumeroPagos, value);
                break;
        }
        fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int col){
        return nombreColumnas.get(col);
                
    }
    
    public Class getColumnClass(int col){
        return clasesColumnas.get(col);
    }
    
    class Data{
        private PagoTrabajador empleado;
        private String departamento;
        private Hashtable<String,ConstructorVariacionSalarial> datos;
        private FabricaVariacionesSalariales fab = new FabricaVariacionesSalariales();

        public Data(PagoTrabajador empleado, Hashtable<String, ConstructorVariacionSalarial> datos,String departamento) {
            this.empleado = empleado;
            this.datos = datos;
            this.departamento = departamento;
        }
        
        public String getPuesto(){
            return empleado.getTrabajador().getNombreEmpleo();
        }
        
        public Persona getEmpleado(){
            return empleado.getTrabajador().getPersona();
        }
        
        public float getSueldoBase(){
            return empleado.getTrabajador().getSalario();
        }
        
        public ConstructorVariacionSalarial getDato(String llave){
            return datos.get(llave);
        }
        
        public String getDepartamento(){
            return departamento;
        }

        public void setEmpleado(PagoTrabajador empleado) {
            this.empleado = empleado;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        public void setDatos(float dato, int tipo) {
            
        }
        
        
        
        public float getTotalPagar(){
            return empleado.getTotalAPagar();
        }
        
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return true;
    }
    
}
