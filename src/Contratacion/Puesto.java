package Contratacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Edwin Chocoy
 */
public interface Puesto {
    
    public void setNombre(String nombre);
    
    public String getNombre();
    
    public void setDescripcion(String descripcion);
    
    public String getDescripcion();
    
    public void setSalario(float valor);
    
    public float getSalario();
    
    public void setRequisitos(String requisito);
    
    public String getRequisitos();
    
}
