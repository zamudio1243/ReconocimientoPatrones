package herramientasclasificadores;
/*
Hector septiembre 2019 
*/

import java.util.ArrayList;

public class MatrizConfusion {
   private double[][] matriz;
   private double[] vectorEficacia;
   private ArrayList<Patron> instancias;
   private ArrayList<String> clases; //Cuantas clases contiene las instancias

    public MatrizConfusion(ArrayList<Patron> instancias) {
        this.instancias = instancias;
        this.clases = new ArrayList<>();
        this.matriz= null;
        this.vectorEficacia= null;
        inicializarMatriz();
        inicializarVectorEficiencia();
    }

    private void inicializarVectorEficiencia() {
        for (int i = 0; i <matriz.length  ; i++) {
            int num=0;
            for (int j = 0; j < matriz.length ; j++) {
                num+=this.matriz[i][j];
            }
            this.vectorEficacia[i]= this.matriz[i][i]*100/num;
        }
        int sum=0;
        for (int i = 0; i < vectorEficacia.length -1; i++) {
            sum+=vectorEficacia[i];
        }
        vectorEficacia[vectorEficacia.length-1]=sum/(vectorEficacia.length-1);


    }

    private void inicializarMatriz() {
        for (Patron p: this.instancias) {
            if(!this.clases.contains(p.getClase()))
                this.clases.add(p.getClase());
        }
        int m = this.clases.size();
        int n= m+1;
        this.matriz= new double[m][m];
        this.vectorEficacia= new double[n];


        for (Patron p: this.instancias) {
            int r= this.clases.indexOf(p.getClase());
            int c=this.clases.indexOf(p.getClaseResultante());
            this.matriz[r][c]++;
        }

    }

    public double EficaciaTotal() {
        return this.vectorEficacia[this.vectorEficacia.length-1];
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i <this.matriz.length  ; i++) {
            aux+="|";
            for (int j = 0; j < this.matriz.length ; j++) {
                aux+=" "+this.matriz[i][j]+", ";
            }

            aux+="|  "+this.vectorEficacia[i]+"% \n";
        }
        aux+="Eficacia total: "+this.vectorEficacia[this.vectorEficacia.length-1]+"%\n";
        return aux;
    }
}
