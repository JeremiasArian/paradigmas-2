package actividad2209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Bienvenido, administrador.");
        System.out.println("Opciones disponibles:");
        System.out.println("1) Agregar alumno");
        System.out.println("-1 Salir de este programa.");

        ingresarInputYValidar();
    }

    private static void ingresarInputYValidar(){
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
            } else if(opcion == 1){
                opcion = 0;
                registrarAlumno();
            } else{
                System.out.println("Opciones disponibles:");
                System.out.println("1) Agregar alumno");
                System.out.println("-1 Salir de este programa.");
                opcion = 0;
            }
        }
    }

    private static void registrarAlumno(){
        Alumno alumno = new Alumno();
        System.out.println("Ingrese el turno al que asiste");
        System.out.println("1) Mañana");
        System.out.println("2) Tarde");
        System.out.println("3) A los dos");
    }
}
