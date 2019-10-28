package clustering;
/*
Hector septiembre 2019 
*/
import javax.swing.*;import java.awt.*;

public class JFrameImage extends JFrame {
    public JFrameImage(Image imagenOriginal){
        JLabel label = new JLabel(new ImageIcon(imagenOriginal));
        this.add(label);
        this.setSize(imagenOriginal.getWidth(this),imagenOriginal.getHeight(this));
        this.setVisible(true);
    }
}
