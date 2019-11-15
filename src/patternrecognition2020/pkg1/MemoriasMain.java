package patternrecognition2020.pkg1;
/*
Hector noviembre 2019 
*/

import herramientasclasificadores.Patron;
import memorias.CAP;
import memorias.Lernmatrix;

import java.util.ArrayList;


public class MemoriasMain {

    public static void lernmatrix(){
        int[][] x = new int[5][6];
        int[][] y = new int[3][3];
        x[0]= new int[]{1,0,1,0,1,0};
        x[1]= new int[]{1,1,0,0,1,1};
        x[2]= new int[]{1,0,1,1,0,2};
        x[3]= new int[]{0,1,0,1,1,0};
        x[4]= new int[]{0,0,1,0,1,2};
        y[0]= new int[]{1,0,0};
        y[1]= new int[]{0,1,0};
        y[2]= new int[]{0,0,1};


        Lernmatrix lm = new Lernmatrix(x,y,1);
        lm.aprendizaje();
        lm.mostrarM();
        System.out.println("Efectividad: "+lm.recuperacion(x));
    }
    public static void cap(){
        ArrayList<Patron> conjFundamental = new ArrayList<>();
        conjFundamental.add(new Patron(new double[]{2.1,3.8},"uno"));
        conjFundamental.add(new Patron(new double[]{6.3,3.8},"dos"));
        CAP cap = new CAP(conjFundamental);
        cap.aprendizaje();
        cap.mostrarMemoria();
        System.out.println();
        cap.recuperacion(conjFundamental);
    }
    public static void main(String[] args) {
        MemoriasMain.cap();


    }
}
