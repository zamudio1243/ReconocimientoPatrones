package patternrecognition2020.pkg1;
import clasificadores.Knn;
import herramientasclasificadores.Herramientas;
import clasificadores.MinimaDistancia;
import herramientasclasificadores.Patron;


import java.util.ArrayList;


public class SupervisadoMain {

    public static int[] arregloBinario(int n){
        String bin= Integer.toBinaryString(n);
        String[] aux= bin.split("");
        int[] binario = new int[aux.length];
        for (int i = aux.length -1; i > -1 ; i--) {
            binario[i]= Integer.parseInt(aux[i]) ;
        }
        return binario;
    }

    public static void main(String[] args) {
        /*
        int mejor= 0;
        double eficaciaMax= 0.0;
        double tope = 1073741823;
        for (double i = tope; i > -1 ; i-=100) {
            MinimaDistancia md = new MinimaDistancia();
            int[] aux=arregloBinario((int)i);
            Herramientas.leerDatos(aux);
            md.entrenar(Herramientas.instancias);
            md.clasificar(Herramientas.instancias);
            double eficaciaNew= md.getEficaciaTotal();
            if(eficaciaMax<eficaciaNew) {
                mejor = (int)i;
                eficaciaMax = eficaciaNew;
            }
            System.out.println("eficacia:  "+eficaciaMax+"\n mejor: "+mejor);

        }
        System.out.println("Mejor"+mejor);

         */



        MinimaDistancia md = new MinimaDistancia();
        Knn knn= new Knn(3);
        Herramientas.leerDatos();
        md.entrenar(Herramientas.instancias);
        knn.entrenar(Herramientas.instancias);
        Herramientas.leerDatos();
        md.clasificar(Herramientas.instancias);
        knn.clasificar((ArrayList<Patron>)Herramientas.instancias.clone());
        System.out.println(md.getMc().toString());
        System.out.println(knn.getMc().toString());


    }
    
}
