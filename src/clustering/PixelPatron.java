package clustering;
/*
Hector octubre 2019 
*/

import herramientasclasificadores.Patron;

public class PixelPatron extends Patron {
    private int x;
    private int y;

    public PixelPatron(int n, int x, int y) {
        super(n);
        this.x= x;
        this.y= y;
    }

    public PixelPatron(double[] vector, String clase, int x, int y) {
        super(vector, clase);
        this.x= x;
        this.y= y;
    }

    public PixelPatron(Patron aux, int x, int y) {
        super(aux);
        this.x= x;
        this.y= y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
