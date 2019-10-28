package clustering;
/*
Hector septiembre 2019 
*/

import clasificadores.CMeans;
import herramientasclasificadores.Patron;
import herramientasclasificadores.PatronRepresentativo;

import java.awt.*;
import java.util.ArrayList;

public class ClusteringMain {

    public static void main(String[] args){
        Image io = ImageManager.openImage();
        JFrameImage jFrameImage = new JFrameImage(io);
        jFrameImage.setVisible(true);

        ArrayList<Patron> instancias = ImageAdapter.obtenerInstancias(io);
        CMeans cMeans = new CMeans(20);
        cMeans.entrenar(instancias);
        System.out.println("Entrene");
        cMeans.clasificar(instancias);
        Image nueva = ImageAdapter.generarImagenClusterizada(cMeans.getCentroides(),instancias,new Dimension(io.getWidth(null),io.getHeight(null)));
        JFrameImage jFrameImageNuevo = new JFrameImage(nueva);
        System.out.println();
    }

}
