/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contratacion;

import java.util.ArrayList;
import OtrasClases.*;

/**
 *
 * @author Hugo
 */
public class PorFase implements FormaCalificar{
    private int valorMinimo;
    private ArrayList<Integer> fasesImportante;
    private IteradorAspirantes aspirantes;
    
    public PorFase(int valor, IteradorAspirantes aspirantes){
        this.valorMinimo = valor;
        this.aspirantes = aspirantes;
        fasesImportante = new ArrayList<>();
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

    public ArrayList<Integer> getFasesImportante() {
        return fasesImportante;
    }

    public void setFasesImportante(ArrayList<Integer> fasesImportante) {
        this.fasesImportante = fasesImportante;
    }

    public void setFaseImportante(int fase){
        fasesImportante.add(fase);
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
                Calificacion fase = fases.getNext();
                if(fasesImportante.contains(fase.getNumeroFase())){
                    aux+= fases.getNext().getPuntuacionDesempeño()*2;
                    conteo+=2;
                }
                else{
                    aux+= fases.getNext().getPuntuacionDesempeño();
                    conteo++;  
                }
            }
            if(aux/conteo >= valorMinimo) finalistas.add(aspirante);
        }
        return finalistas;
    }
}
