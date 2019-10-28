package clustering;
/*
Hector octubre 2019 
*/

import herramientasclasificadores.Patron;
import herramientasclasificadores.PatronRepresentativo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageAdapter {
    public static ArrayList<Patron> obtenerInstancias(Image io){
        ArrayList<Patron> aux = new ArrayList<>();
        BufferedImage bi = ImageManager.toBufferedImage(io);
        for (int i = 0; i < bi.getWidth() ; i++) {
            for (int j = 0; j < bi.getHeight() ; j++) {
                Color color = new Color(bi.getRGB(i,j));
                PixelPatron pp = new PixelPatron(new double[]{color.getRed(),color.getGreen(),color.getBlue()},"",i,j);
                aux.add(pp);
            }
        }
        return  aux;
    }
    public static Image generarImagenClusterizada(PatronRepresentativo[] representativos, ArrayList<Patron> pixeles, Dimension dim){
        //Image imgResult = null;
        BufferedImage bufferedImage = new BufferedImage((int)dim.getWidth(),(int)dim.getHeight(),BufferedImage.TYPE_INT_RGB);
        int i = 0;
        // recorremos las instancias
         for(Patron aux: pixeles){

             PixelPatron pxp = (PixelPatron)aux;
             String clase = pxp.getClaseResultante();
             double vector[] = new double[]{0,0,0};

             representativos:for(PatronRepresentativo pr: representativos){
                 if (clase.equals(pr.getClase())) {
                     vector = pr.getVector();
                     break representativos;
                 }

             }
             bufferedImage.setRGB(pxp.getX(),pxp.getY(), new Color((int)vector[0],(int) vector[1],(int) vector[2]).getRGB());
            // if (i == 300)
              //   break;

             System.out.println(i);
             i++;

         }

        return  ImageManager.toImage(bufferedImage);

    }

}
