/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edwin Chocoy
 */
public class Conexion {
    private static Conexion Conexion;
    private static EntityManagerFactory emf;
    
    private Conexion(){
        emf = Persistence.createEntityManagerFactory("Recursos_HumanosPU");
    }
    
    public static Conexion getConexion(){
        if(Conexion==null)
            Conexion = new Conexion();
        return Conexion;
    }
    
    public EntityManagerFactory getEMF(){
        return emf;
    }
    
}
