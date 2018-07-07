/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

/**
 *
 * @author Hugo
 */
public class FabricaVariacionesSalariales implements FactoryVariacionesSalariales{
    public static final String bonificacion ="bon";
    public static final String igss ="igss";
    public static final String prestamo ="pres";
    public static final String horasExtra ="horas";
    @Override
    public ConstructorVariacionSalarial crearObjeto(String tipo) {
        ConstructorVariacionSalarial con =null;
        switch(tipo){
            case bonificacion:
                con = new ConstructorBonificacion(new Bonificacion());
                break;
            case igss:
                con = new ConstructorIgss(new IGSS());
                break;
            case prestamo:
                con = new ConstructorPrestamo(new Prestamo());
                break;
            case horasExtra:
                con = new ConstructorHorasExtra(new HorasExtra());
                break;
        }
        return con;
    }
    
}
