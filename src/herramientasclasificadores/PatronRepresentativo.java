package herramientasclasificadores;

public class PatronRepresentativo extends Patron {
    private int contador;
   
    public PatronRepresentativo(Patron a){
        super(a.getVector().length);
        super.setClase(a.getClase());
        this.contador=0;
        acumular(a);
    }
    public  PatronRepresentativo(Patron p, String s){
        super(p.getVector(),s);
        contador=0;
        acumular(p);
    }

    public  void acumular(Patron a) {
       for (int x=0;x<a.getVector().length;x++){
            super.getVector()[x]+=a.getVector()[x];
        }
       this.contador++;
    }
    
    public void actualizar(){
        for (int x=0;x<super.getVector().length;x++){
            super.getVector()[x]/=this.contador;
        }
        this.contador = 0;
    }

    @Override
    public String toString() {
        String aux="{";
        for (double a: this.getVector()) {
            aux+="["+a+"]";
        }
        aux+="}";
        return aux;

    }
}
