/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class Promedio implements FormaCalificar{
    private int valorMinimo;
    private IteradorAspirantes aspirantes;
    public Promedio(int valor, IteradorAspirantes aspirantes){
        this.valorMinimo = valor;
        this.aspirantes = aspirantes;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public IteradorAspirantes getAspirantes() {
        return aspirantes;
    }

    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public void setAspirantes(IteradorAspirantes aspirantes) {
        this.aspirantes = aspirantes;
    }

    @Override
    public ArrayList<Aspirantes> ejecutar() {
        ArrayList<Aspirantes> finalistas = new ArrayList<>();
        while(aspirantes.hasMore()){
            int aux = 0;
            int conteo = 0;
            Aspirantes aspirante = (Aspirantes) aspirantes.getNext();
            IteradorFases fases = (IteradorFases) aspirante.crearIterador();
            while(fases.hasMore()){
                aux+= fases.getNext().getPuntuacionDesempeño();
                conteo++;
            }
            if(aux/conteo >= valorMinimo) finalistas.add(aspirante);
        }
        return finalistas;
    }
    
}
