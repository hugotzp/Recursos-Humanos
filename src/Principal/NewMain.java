/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Estructura.Departamentos;
import Estructura.JpaControllerDepartamentos;
import Estructura.JpaControllerTrabajador;
import Estructura.Trabajador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Recursos_HumanosPU");
        EntityManager em = emf.createEntityManager();
        

        JpaControllerDepartamentos pc = new JpaControllerDepartamentos(emf);
        
        Departamentos p = new Departamentos();
        p.obtenerEmpleados();
        
        JpaControllerTrabajador tc = new JpaControllerTrabajador(emf);
        
        Trabajador t = new Trabajador();
        
        
    }
    
}
