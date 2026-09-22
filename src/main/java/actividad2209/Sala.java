package actividad2209;

import java.util.ArrayList;

public class Sala {
    private ArrayList<Alumno> listaDeAlumnos = new ArrayList<>();
    private ArrayList<Maestra> listaDeMaestras = new ArrayList<>();
    private TipoDeSala tipoDeSala;

    public ArrayList<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(ArrayList<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public ArrayList<Maestra> getListaDeMaestras() {
        return listaDeMaestras;
    }

    public void setListaDeMaestras(ArrayList<Maestra> listaDeMaestras) {
        this.listaDeMaestras = listaDeMaestras;
    }

    public TipoDeSala getTipoDeSala() {
        return tipoDeSala;
    }

    public void setTipoDeSala(TipoDeSala tipoDeSala) {
        this.tipoDeSala = tipoDeSala;
    }

    public enum TipoDeSala {
        LACTORIO,
        DEAMBULADOR,
        DEAMBULADOR_2,
        SALA_DE_2,
        SALA_DE_3,
    }
}
