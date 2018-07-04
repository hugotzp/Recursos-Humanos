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
    public ArrayList Departamentos;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getDepartamentos() {
        Conexion con = Conexion.getConexion();
        JpaControllerDepartamentos d = new JpaControllerDepartamentos(con.getEMF());
        return new ArrayList(d.findDepartamentosEntities());
        
    }

    @Override
    public void guardarDepartamentos() {
        Conexion con = Conexion.getConexion();
        JpaControllerDepartamentos d = new JpaControllerDepartamentos(con.getEMF());
        
        for(int index=0;index<=Departamentos.size();index++){
            d.create((Departamentos) Departamentos.get(index));
        }
        
    }
  
}
