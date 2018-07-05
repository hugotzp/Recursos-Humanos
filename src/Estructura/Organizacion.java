/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public class Organizacion implements Empresa, AdministradorDepartamentos{


    public String Nombre;
    public String TipoSociedad;
    public ArrayList<Departamentos> Departamentos;
    
    public ArrayList cargarEmpleados(ArrayList<Departamentos> deps){
        
        for(int index=0;index<deps.size();index++){
            deps.get(index).obtenerEmpleados();
        }
        
        return deps;
        
    }
    
    
    @Override
    public void mostrarEstructuraOrganizacional() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDepartamento(Departamentos departamento) {
        Departamentos.add(departamento);
    }

    @Override
    public void crearEstructura() {
        Conexion con = Conexion.getConexion();
        JpaControllerDepartamentos d = new JpaControllerDepartamentos(con.getEMF());
        Departamentos = new ArrayList(d.findDepartamentosEntities());

        cargarEmpleados(Departamentos);
    }

    @Override
    public ArrayList getEstructura() {
        
        crearEstructura();

        return (Departamentos);
        
    }
    
    @Override
    public ArrayList getIdDepartamentos(){
        Conexion con = Conexion.getConexion();
        JpaControllerDepartamentos d = new JpaControllerDepartamentos(con.getEMF());
        ArrayList<Departamentos> deps = new ArrayList(d.findDepartamentosEntities());
        
        return deps;
        
    }

    @Override
    public void guardarDepartamentos() {
        Conexion con = Conexion.getConexion();
        JpaControllerDepartamentos d = new JpaControllerDepartamentos(con.getEMF());
        System.out.println(Departamentos.size());
        for(int index=0;index<Departamentos.size();index++){
            
            boolean existe = d.depatamentoExiste(Departamentos.get(index).getNombre());
            
            if(existe==false)
                d.create((Departamentos) Departamentos.get(index));
        }
        
    }
  
}
