/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface AdministradorDepartamentos {
    
    public ArrayList getEstructura();
    
    public ArrayList getIdDepartamentos();
    
    public Departamentos getDepartamento(Long id);
    
}
