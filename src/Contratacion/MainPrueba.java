/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import Personas.*;
import java.util.Date;
/**
 *
 * @author Edwin Chocoy
 */
public class MainPrueba {
    public static void main(String[] args) {
        // TODO code application logic here
        Persona persona = new Personal();
        persona.setNombre("Edwin");
        persona.setApellido("Chocoy");
        persona.setDPI("123423423");
        persona.setGenero(true);
        Date fecha = new Date(98,8,8);
        persona.setFechaNacimiento(fecha);
        
        
        PersonasInteresadas aspirante = new Aspirantes(persona);
        
        
      
        
        
        
    }
    
}
