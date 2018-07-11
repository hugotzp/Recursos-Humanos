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
public class ModeloTablaCalificaciones extends AbstractTableModel{
    private ArrayList<String> nombreColumnas;
    private ArrayList<Class> clasesColumnas;
    private ArrayList<Aspirantes> aspirantes;
    
    public ModeloTablaCalificaciones(){
        this.nombreColumnas = new ArrayList<>();
        this.clasesColumnas = new ArrayList<>();
        this.aspirantes = new ArrayList<Aspirantes>();
        this.nombreColumnas.add("Nombre");
        this.clasesColumnas.add(String.class);
        this.nombreColumnas.add("Apellido");
        this.clasesColumnas.add(String.class);
    }
    
    public void LlenarTabla(Reclutar reclutamiento){
        this.nombreColumnas = new ArrayList<>();
        this.clasesColumnas = new ArrayList<>();
        this.nombreColumnas.add("Nombre");
        this.clasesColumnas.add(String.class);
        this.nombreColumnas.add("Apellido");
        this.clasesColumnas.add(String.class);
        reclutamiento.cargarAspirantes();
        ArrayList<FasesDeReclutamiento> fases = reclutamiento.getFasesRelacionadas();
        for(FasesDeReclutamiento f : fases){
            f.obtenerNombre();
            this.nombreColumnas.add(f.getNombre());
            this.clasesColumnas.add(Integer.class);
        }
        this.aspirantes = reclutamiento.getAspirantes();
        fireTableStructureChanged();
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
    public Object getValueAt(int row, int col) {
        Object retornar = null;
        Aspirantes asp = aspirantes.get(row);
        switch(col){
            case 0:
                retornar = asp.getPersona().getNombre();
                break;
            case 1:
                retornar = asp.getPersona().getNombre();
                break;
            default:
                retornar = ((CalificacionesAspirante)asp.getFasesReclutamiento().get(col-2)).getDesempeño();
        }
        return retornar;
    }
}
