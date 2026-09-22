package actividad2209;

import java.util.ArrayList;

public class Sala {
    private ArrayList<Alumno> listaDeAlumnos = new ArrayList<>();

    public ArrayList<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(ArrayList<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public enum TipoDeSala {
        LACTORIO,
        DEAMBULADOR,
        DEAMBULADOR_2,
        SALA_DE_2,
        SALA_DE_3,
    }
}
