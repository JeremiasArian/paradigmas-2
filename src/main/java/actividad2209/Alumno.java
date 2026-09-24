package actividad2209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Alumno {
    private Turno turno;
    private boolean accesoAlcomedor = false;
    private boolean poseeHermanoInscripto = false;
    private int edad = 0;
    private boolean meses = false;
    private boolean anios = false;

    public Alumno(){}

    public void registrar() {
        System.out.println("Primero, Ingrese la edad del nene");
        System.out.println("1) Para ingresar la edad en meses");
        System.out.println("2) Para ingresar la edad en años");
        asignarEdad();
        System.out.println("Ahora, Ingrese el turno al que asistirá");
        System.out.println("1) Mañana");
        System.out.println("2) Tarde");
        System.out.println("3) A los dos");
        ingresarInputYValidar(this);
    }

    private void asignarEdad(){
        int opcion = -2;
        while (true){
            Scanner s = new Scanner(System.in);
            try {
                opcion = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(opcion ==-1) {
                System.out.println("Saliendo...");
                break;
            } else if(opcion == 1) {
                opcion = 0;
                System.out.println("Cuantos meses tiene el nene?");
                int edad = -2;
                while (true) {
                    Scanner s1 = new Scanner(System.in);
                    try {
                        edad = s1.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    }

                    if (edad < 0 || edad > 11) {
                        System.out.println("Sólo se permiten entre 0 a 11 meses");
                    } else {
                        this.edad = edad;
                        meses=true;
                        break;
                    }
                }
                break;
            }else if(opcion==2) {
                opcion = 0;
                System.out.println("Cuantos años tiene el nene?");
                int edad = -2;
                while (true) {
                    Scanner s1 = new Scanner(System.in);
                    try {
                        edad = s1.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    }

                    if (edad < 1 || edad > 3) {
                        System.out.println("Sólo se permiten entre 1 a 3 años");
                    } else {
                        this.edad = edad;
                        meses=true;
                        break;
                    }
                }
                break;
            } else{
                System.out.println("Opciones disponibles:");
                System.out.println("1) Para ingresar la edad en meses");
                System.out.println("2) Para ingresar la edad en años");;
                opcion = 0;
            }
        }
    }

    private static Alumno ingresarInputYValidar(Alumno a){
        int opcion = 0;
        while (opcion==0){
            Scanner s = new Scanner(System.in);
            try {
                opcion = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(opcion ==-1) {
                System.out.println("Saliendo...");
                break;
            } else if(opcion == 1) {
                opcion = 0;
                a.setTurno(Alumno.Turno.MANANA);
            }else if(opcion==2) {
                opcion = 0;
                a.setTurno(Alumno.Turno.TARDE);
            }else if(opcion==3) {
                opcion = 0;
                a.setTurno(Alumno.Turno.DOBLE);
            } else{
                System.out.println("Opciones disponibles:");
                System.out.println("1) Mañana");
                System.out.println("2) Tarde");
                System.out.println("3) A los dos");
                opcion = 0;
            }
        }
        return a;
    }

    public boolean isAccesoAlcomedor() {
        return accesoAlcomedor;
    }

    public void setAccesoAlcomedor(boolean accesoAlcomedor) {
        this.accesoAlcomedor = accesoAlcomedor;
    }

    public boolean isPoseeHermanoInscripto() {
        return poseeHermanoInscripto;
    }

    public void setPoseeHermanoInscripto(boolean poseeHermanoInscripto) {
        this.poseeHermanoInscripto = poseeHermanoInscripto;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public boolean isMeses() {
        return meses;
    }

    public void setMeses(boolean meses) {
        this.meses = meses;
    }

    public boolean isAnios() {
        return anios;
    }

    public void setAnios(boolean anios) {
        this.anios = anios;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public enum Turno{
        MANANA,
        TARDE,
        DOBLE
    }
}
