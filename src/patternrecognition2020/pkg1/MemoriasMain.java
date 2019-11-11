package patternrecognition2020.pkg1;
/*
Hector noviembre 2019 
*/

import memorias.Learnmatrix;


public class MemoriasMain {
    public static void main(String[] args) {
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


        Learnmatrix lm = new Learnmatrix(x,y,1);
        lm.aprendizaje();
        lm.mostrarM();
        System.out.println("Efectividad: "+lm.recuperacion(x));


    }
}
