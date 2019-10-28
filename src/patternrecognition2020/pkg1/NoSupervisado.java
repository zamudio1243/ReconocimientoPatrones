package patternrecognition2020.pkg1;
/*
Hector octubre 2019 
*/

import clasificadores.CMeans;
import herramientasclasificadores.Herramientas;
import herramientasclasificadores.Patron;
import javafx.scene.control.Cell;

import java.util.ArrayList;

public class NoSupervisado {
    public static void  main(String[] agrs){
        Herramientas.leerDatos();
        CMeans cMeans= new CMeans(15);
        cMeans.entrenar(Herramientas.instancias,new int[]{0,99,149});
        cMeans.clasificar((ArrayList<Patron>) Herramientas.instancias.clone());


        System.out.println("Termine");





    }
}
