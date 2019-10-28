package clasificadores;
/*
Hector octubre 2019 
*/

import herramientasclasificadores.Herramientas;
import herramientasclasificadores.Patron;
import herramientasclasificadores.PatronRepresentativo;

import java.util.ArrayList;
import java.util.Random;



public class CMeans implements Clasificador {
    private int c;
    private PatronRepresentativo[] centroides;


    public CMeans(int c){
        this.c=c;
        this.centroides= new PatronRepresentativo[c];
    }

    public void entrenar(ArrayList<Patron> patrones, int pos[]){
        for(int x=0; x<pos.length;x++){
            this.centroides[x]= new PatronRepresentativo(patrones.get(pos[x]));
            this.centroides[x].setClase(""+x);
        }
    }
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        System.out.println("Estoy entrenando");
        Random ran= new Random();
        int pos= ran.nextInt(instancias.size());
        centroides[0] = new PatronRepresentativo(instancias.get(pos));
        centroides[0].setClase(""+0);
        int numCentroides= 1;

        while(numCentroides < this.c){
            pos= ran.nextInt(instancias.size());
            if(!existe(instancias.get(pos),numCentroides)){
                centroides[numCentroides] = new PatronRepresentativo(instancias.get(pos));
                centroides[numCentroides].setClase(""+numCentroides);
                numCentroides++;
            }
        }
    }

    @Override
    public void clasificar(Patron patron) {}
    @Override
    public void clasificar(ArrayList<Patron> patrones) {
        PatronRepresentativo[] nuevos;
        int i = 1;
        do {
            i++;
            clasificamos(patrones);
            nuevos=  reAjustarCentroides(patrones);
        }while (sonDiferentes(nuevos));
        System.out.println("iteraciones: "+i);
        for (int j = 0; j < this.centroides.length ; j++) {
            System.out.println(centroides[j].toString());
        }

    }

    private PatronRepresentativo[] reAjustarCentroides(ArrayList<Patron> patrones) {
        PatronRepresentativo[] nuevos = new PatronRepresentativo[this.c];

        for (Patron aux: patrones) {
            int i = Integer.parseInt(aux.getClaseResultante());
            if(nuevos[i]==null) {
                nuevos[i] = new PatronRepresentativo(aux);
                nuevos[i].setClase(""+i);

            }
            else
                nuevos[i].acumular(aux);


        }
        for (int j = 0; j < nuevos.length; j++) {
            nuevos[j].actualizar();
        }
        return nuevos;

    }

    private boolean sonDiferentes(PatronRepresentativo[] nuevos) {
        //Si determina que son diferentes, sustituimos a los patrones actuales
        for (int i = 0; i < nuevos.length; i++)
            if(!nuevos[i].equals(centroides[i])) {
                centroides=nuevos.clone();
                return true;
            }
        return  false;
    }

    private void clasificamos(ArrayList<Patron> patrones){
        for (Patron aux: patrones) {
            double disC= Herramientas.calcularDistanciaEuclidiana(aux,this.centroides[0]);
            aux.setClaseResultante(this.centroides[0].getClase());
            //Recorremos patrones
            for (int i = 1; i < this.centroides.length ; i++) {
                double daux = Herramientas.calcularDistanciaEuclidiana(aux,this.centroides[i]);
                if (daux < disC){
                    disC= daux;
                    aux.setClaseResultante(this.centroides[i].getClase());
                }
            }
        }



    }

    private boolean existe(Patron patron, int i) {
        for (int j = 0; j <i ; j++) {
            if(this.centroides[j].equals(patron)){
                return true;
            }
        }
        return false;

    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public PatronRepresentativo[] getCentroides() {
        return centroides;
    }

    public void setCentroides(PatronRepresentativo[] centroides) {
        this.centroides = centroides;
    }
}
