package memorias;
/*
Hector noviembre 2019
Clasificador supervisado-heteroasociativo
basado en la Learnmatrix de Setinbuch
para patrones binarios equis de
*/

import herramientasclasificadores.Herramientas;

public class Learnmatrix {
    private int[][] x; // patrones
    private int[][] y; // clases
    private int[][] m; // memoria
    private int E; // epsilon

    public Learnmatrix(int[][] x, int[][] y, int e) {
        this.x = x;
        this.y = y;
        this.E = e;
        m = new int[y.length][x[0].length -1];
        for (int i = 0; i < y.length ; i++) {
            for (int j = 0; j < x[i].length -1 ; j++) {
                m[i][j] = 0;
            }
        }
    }

    public void aprendizaje(){
        for (int i = 0; i < y.length; i++) {
            // Recorre patrones
            int clase= x[i][x[i].length -1];
            for (int j = 0; j < x[i].length -1; j++) {
                // Recorre caracteristicas de patrones
                if(x[i][j] == 1 && y[clase][clase] == 1){
                    m[clase][j]+=E;
                }
                if(x[i][j] == 0 && y[clase][clase] == 1){
                    m[clase][j]-=E;
                }
            }
        }
    }

    public double recuperacion(int[][] p){
        double efectividad = 0.0;
        int[][] trans = transpuesta(p,true);
        int[][] result = Herramientas.multiplicadorMatrices(this.m,trans);
        //verificar esto
        int[][] claseResult = transformarAPatron(result);
        for (int i = 0; i < y.length ; i++) {
            int aux = 0;
            for (int j = 0; j < y. length ; j++) {
                if (y[i][j] == claseResult[i][j]){
                    aux+=1;
                }
            }
            if (aux == y.length)
                efectividad+=1;
        }
        return  efectividad / y.length * 100;
    }

    public  int[][] transpuesta(int[][] p, boolean clase){
        int[][] trans;
        if(clase){
            trans =  new int[p[0].length-1][p.length];
            for (int i = 0; i < trans.length; i++) {
                for (int j = 0; j < trans[i].length; j++) {
                    trans[i][j] = p[j][i];
                }
            }
        }
        else {
            trans = new int[p[0].length][p.length];
            for (int i = 0; i < trans.length; i++) {
                for (int j = 0; j < trans[i].length; j++) {
                    trans[i][j] = p[j][i];

                }
            }
        }
        return trans;
    }

    public int[][] transformarAPatron(int[][] a){
        int[][] patron = transpuesta(a,false);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < patron.length ; i++) {
            for (int j = 0; j < patron[i].length; j++) {
                if (max < patron[i][j])
                    max = patron[i][j];
            }
            for (int j = 0; j < patron[i].length; j++) {
                if (max == patron[i][j])
                    patron[i][j] = 1;
                else
                    patron[i][j] = 0;
            }
        }

        return patron;
    }


    public void mostrarM(){
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(String.format("%3d",m[i][j]));
            }
            System.out.println();
        }
    }

    public int[][] getX() {
        return x;
    }

    public void setX(int[][] x) {
        this.x = x;
    }

    public int[][] getY() {
        return y;
    }

    public void setY(int[][] y) {
        this.y = y;
    }

    public int[][] getM() {
        return m;
    }

    public void setM(int[][] m) {
        this.m = m;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }
}
