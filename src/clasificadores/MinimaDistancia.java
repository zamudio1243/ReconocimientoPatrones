/*
Hector agosto 2019
*/
package clasificadores;

import herramientasclasificadores.Herramientas;
import herramientasclasificadores.MatrizConfusion;
import herramientasclasificadores.Patron;
import herramientasclasificadores.PatronRepresentativo;
import java.util.ArrayList;

public class MinimaDistancia implements Clasificador {

    private  ArrayList<PatronRepresentativo> representativos;
    private MatrizConfusion mc;
    private  double eficaciaTotal;
    
    public MinimaDistancia() {
        this.representativos = new ArrayList<PatronRepresentativo>();
        this.mc = null;
    }


    public MatrizConfusion getMc() {
        return mc;
    }

    @Override
    public void entrenar(ArrayList<Patron> instancias) {
       
        // agregamos el primer representativo 
        representativos.add(new PatronRepresentativo(instancias.get(0)));
        // recorrer todas las instancias 
        for (int x=1; x<instancias.size();x++){
            Patron aux = instancias.get(x);
            // es verificar la existencia o no el representativo
            int pos = representativos.indexOf(aux);
            if(pos!=-1){
                
                 // ACUMULAR AL REPRESENTATIVO QUE LE CORRESPONDA
                
                representativos.get(pos).acumular(aux);
              
                
            }else {
           // crear un nuevo patron representativo
                // agregamos el primer representativo 
                representativos.add(new PatronRepresentativo(aux));
            }
        }
        for(PatronRepresentativo aux: representativos){
            aux.actualizar();
        }
    
        
    }

    public double getEficaciaTotal() {
        return eficaciaTotal;
    }

    @Override
    public void clasificar(Patron patron) {
        int iMenor=0;
        double dMenor = Herramientas.calcularDistanciaEuclidiana
        (patron,this.representativos.get(0));
        int indice=0;
        // en proceso iterativo calcular las distancias con respecto a los representativos
        for(int i = 1; i < this.representativos.size();i+=1){
            double dN = Herramientas.calcularDistanciaEuclidiana(patron,this.representativos.get(i));
            if(dN<dMenor){
                dMenor = dN;
                iMenor = i;
            }
        }
        patron.setClaseResultante(
                this.representativos.get(iMenor).getClase());

    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
       for(Patron p: patrones){
           clasificar(p);
       }
       this.mc= new MatrizConfusion(patrones);
       this.eficaciaTotal= this.mc.EficaciaTotal();
    }

   
}
