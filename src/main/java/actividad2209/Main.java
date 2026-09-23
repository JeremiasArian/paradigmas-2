package actividad2209;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) {
        System.out.println("Iniciando Sistema...");

        long total = 235;
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= total; i = i + 3) {
            try {
                Thread.sleep(50);
                printProgress(startTime, total, i);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Bienvenido, administrador.");

        SalasDisponibles salasDisponibles = new SalasDisponibles();

        salasDisponibles.registrarLactarios();

        System.out.println("Todas las salas se registraron con exito");
        System.out.println("Opciones disponibles para el día de hoy:");
        System.out.println("1) Registrar una sala");
        System.out.println("2) Registrar maestra");
        System.out.println("3) Inscribir alumno");
        System.out.println("4) Eliminar alumno");
        System.out.println("5) Eliminar una sala");
        System.out.println("6) Eliminar una maestra de un salon");
        System.out.println("7) Agregar una maestra a un salon");
        System.out.println("8) Calcular la ganancia mensual del jardín");
        System.out.println("9) Imprimir cuota de un alumno seleccionado");
        System.out.println("10) Imprimir la lista de alumnos ordenada por apellido en formulario independiente");
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

    private static void asignarEdad(Alumno a){
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
                        a.setEdad(edad);
                        a.setMeses(true);
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
                        a.setEdad(edad);
                        a.setMeses(true);
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

    private static void registrarAlumno(){
        Alumno alumno = new Alumno();
        System.out.println("Primero, Ingrese la edad del nene");
        System.out.println("1) Para ingresar la edad en meses");
        System.out.println("2) Para ingresar la edad en años");
        asignarEdad(alumno);
        System.out.println("Ahora, Ingrese el turno al que asistirá");
        System.out.println("1) Mañana");
        System.out.println("2) Tarde");
        System.out.println("3) A los dos");
        ingresarInputYValidar(alumno);
    }

    // Source - https://stackoverflow.com/a/39257908
    // Posted by Mike Shauneu, modified by community. See post 'Timeline' for change history
    // Retrieved 2026-09-23, License - CC BY-SA 3.0
    private static void printProgress(long startTime, long total, long current) {
        long eta = current == 0 ? 0 :
                (total - current) * (System.currentTimeMillis() - startTime) / current;

        String etaHms = current == 0 ? "N/A" :
                String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(eta),
                        TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
                        TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));

        StringBuilder string = new StringBuilder(140);
        int percent = (int) (current * 100 / total);
        string
                .append('\r')
                .append(String.join("", Collections.nCopies(percent == 0 ? 2 : 2 - (int) (Math.log10(percent)), " ")))
                .append(String.format(" %d%% [", percent))
                .append(String.join("", Collections.nCopies(percent, "=")))
                .append('>')
                .append(String.join("", Collections.nCopies(100 - percent, " ")))
                .append(']')
                .append(String.join("", Collections.nCopies(current == 0 ? (int) (Math.log10(total)) : (int) (Math.log10(total)) - (int) (Math.log10(current)), " ")))
                .append(String.format(" %d/%d, ETA: %s", current, total, etaHms));

        System.out.print(string);
    }
}
