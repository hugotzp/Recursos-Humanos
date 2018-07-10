/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Conexion.Conexion;
import Estructura.AdministradorDepartamentos;
import Estructura.Departamentos;
import Estructura.JpaControllerDepartamentos;
import Estructura.Organizacion;
import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public class AdaptadorDepartamentos {
    private AdministradorDepartamentos admonDepartamentos;
    
    public AdaptadorDepartamentos(){     
        admonDepartamentos = new Organizacion();
    }
    
    public Departamentos getDepartamento(Long id){
        return (Departamentos) admonDepartamentos.getDepartamento(id);
    }
    
    public ArrayList<Departamentos> getDepartamentos(){
        return admonDepartamentos.getIdDepartamentos();
    }
    
}
