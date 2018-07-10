/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author Edwin Chocoy
 */
public interface AdministradorEmpleos {
    
    public Long guardarEmpleo(String nombre);
    
    public String getEmpleo(Long id);
    
    public Empleo Existe(String nombre);
    
}
