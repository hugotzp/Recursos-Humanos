/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Estructura.*;
import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Organizacion o = new Organizacion();
        o.Departamentos=o.getDepartamentos();       
        
        System.out.println(o.Departamentos.get(0).Trabajadores.get(0).getPersona().toString());
        
        /*Departamentos d = new Departamentos();
        d.setNombre("Informatica");
        a.add(d);
        
        o.Departamentos.add(d);
        o.guardarDepartamentos();*/
        
    }
    
}
