package memorias;

import herramientasclasificadores.Patron;

import java.util.ArrayList;

public interface Memoria {
    void aprendizaje();
    void recuperacion(ArrayList<Patron> patrones);
}
