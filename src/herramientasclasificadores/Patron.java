/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientasclasificadores;

import java.util.ArrayList;

/**
 *
 * @author Hector
 */
public class Patron {
    
    private double vector[];
    private String clase;
    private String claseResultante;

    public Patron(int n) {
        this.vector = new double[n];
        this.clase = "Desconocida";
        this.claseResultante = "Desconocida";
    }

    public Patron(double[] vector, String clase) {
        this.vector = vector;
        this.clase = clase;
        this.claseResultante = "Desconocida";
    }
    
    public Patron (Patron aux){
        this.clase = aux.getClase();
        this.vector = aux.getVector().clone();
         this.claseResultante = "Desconocida";
    }

    public void desplazar(Patron p){
        double[] vector  = new double[p.getVector().length];
        for (int i = 0; i < p.getVector().length ; i++) {
            vector[i] = this.getVector()[i] - p.getVector()[i];
        }
        this.setVector(vector);
    }

    public double[] getVector() {  return vector;  }


    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClaseResultante() {
        return claseResultante;
    }


    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }

    @Override
    public String toString() {
        String aux = "Vector= ";
        for (int i = 0; i < this.getVector().length; i++) {
            aux+= String.format("[%5.1f]",this.getVector()[i]);
        }
        aux+= "\n Clase:" + this.clase;
        aux+= "\n Clase Resultante:" + this.claseResultante;
        return  aux;
    }

    @Override
    public boolean equals(Object obj) {
        Patron aux= (Patron)obj;
        for (int i = 0; i < aux.vector.length; i++) {
            if(this.vector[i] != aux.vector[i])
                return false;
        }
        return true;
        
    }

    
    
    
}
