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
public class FabricaFormaDePago implements FactoryFormaDePago{
    final public static int cheque = 1;
    final public static int efectivo = 2;
    final public static int notadebito = 3;
    @Override
    public ConstructorFormaDePago crearObjeto(int tipo) {
        switch(tipo){
            case cheque:
                return new ConstructorCheque(new Cheque());
            case efectivo:
                return new ConstructorEfectivo(new Efectivo());
            case notadebito:
                return new ConstructorNotaDebito(new NotaDebito());
            default:
                return null;
        }
    }
    
}
