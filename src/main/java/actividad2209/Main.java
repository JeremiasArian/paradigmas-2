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

        imprimirMenu();

        ingresarInputYValidar(salasDisponibles);
    }

    private static void ingresarInputYValidar(SalasDisponibles sl){
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
                imprimirMenuDeSalas();
                elegirSalaARegistrar(sl);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                imprimirMenu();
            }
            else if(opcion == 2){
                opcion = 0;
                Maestra mae = new Maestra();
                mae.registrarYAsignarASalon(sl);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                imprimirMenu();
            }
            else if(opcion == 3){
                opcion = 0;
                Alumno alumno = new Alumno();
                alumno.registrar(sl);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                imprimirMenu();
            }
            else if(opcion == 4){
                opcion = 0;
                sl.removerAlumno();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                imprimirMenu();
            }
        }
    }

    private static void imprimirMenu(){
        System.out.println("Opciones disponibles para el día de hoy:");
        System.out.println("1) Registrar una sala");
        System.out.println("2) Registrar maestra");
        System.out.println("3) Inscribir alumno");
        System.out.println("4) Dar de baja un alumno");
        System.out.println("5) Eliminar una sala");
        System.out.println("6) Eliminar una maestra de un salon");
        System.out.println("7) Agregar una maestra a un salon");
        System.out.println("8) Calcular la ganancia mensual del jardín");
        System.out.println("9) Imprimir cuota de un alumno seleccionado");
        System.out.println("10) Imprimir la lista de alumnos ordenada por apellido en formulario independiente");
        System.out.println("-1 Salir de este programa.");
    }

    private static void imprimirMenuDeSalas(){
        System.out.println("Ingresá que tipo de salas queres registrar:");
        System.out.println("1) Lactario");
        System.out.println("2) Deambulador tipo 1");
        System.out.println("3) Deambulador tipo 2");
        System.out.println("4) Sala tipo 2");
        System.out.println("5) Sala tipo 3");
    }

    private static void elegirSalaARegistrar(SalasDisponibles sl) {
        int opcion = 0;
        while (opcion == 0) {
            Scanner s = new Scanner(System.in);
            try {
                opcion = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if (opcion == -1) {
                System.out.println("Saliendo...");
                System.exit(0);
            } else if (opcion == 1) {
                sl.registrarLactarios();
                break;
            }
            else if (opcion == 2) {
                sl.registrarDeambuladores1();
                break;
            }
            else if (opcion == 3) {
                sl.registrarDeambuladores2();
                break;
            }
            else if (opcion == 4) {
                sl.registrarSalas2();
                break;
            }
            else if (opcion == 5) {
                sl.registrarSalas3();
                break;
            }
            else {
                System.out.println("Entrada invalida");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                imprimirMenuDeSalas();
                opcion = 0;
            }
        }
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
