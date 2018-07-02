/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

/**
 *
 * @author Hugo
 */
public interface AdaptadorContratacion {
    public Persona getPersona(Integer idAspirante);
    public void guardarPersona(Persona persona);
}
