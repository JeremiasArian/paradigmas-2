package actividad2209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Maestra {
    private String nombre;
    private String apellido;
    private int legajo;
    private boolean recibida;
    private double sueldo;

    public void registrarYAsignarASalon(SalasDisponibles sl){
        if (sl.haySalones()) {
            System.out.println("No hay salones registrados!");
            System.out.println("Primero, registrá al menos uno marcando la opción 1");
            return;
        }

        String entrada = "";
        int contador = 0;
        while (contador <= 4) {
            Scanner s = new Scanner(System.in);

            if (contador == 0) {
                System.out.println("Ingresa el nombre de la Maestra:");
            } else if (contador == 1) {
                System.out.println("Ingresa el apellido de la Maestra:");
            } else if (contador == 2) {
                System.out.println("Ingresa el DNI (sin puntos) de la Maestra:");
            } else if (contador == 3) {
                System.out.println("Ingresa el sueldo (sin puntos ni comas) de la Maestra:");
            } else if(contador==4){
                System.out.println("Esta maestra está recibida?");
                System.out.println("1)Si");
                System.out.println("2)No");
            }

            try {
                entrada = s.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if (entrada.isBlank()) {
                System.out.println("No se permite una entrada vacía!");
                continue;
            }

            if (contador == 0) {
                nombre = entrada;
            } else if (contador == 1) {
                apellido = entrada;
            } else if (contador == 2) {
                try {
                    legajo = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                    contador = 1;
                }
                if (sl.legajoYaUsado(legajo)) {
                    System.out.println("El DNI ingresado ya está registrado");
                    contador = 1;
                    legajo = 0;
                }
            } else if (contador == 3) {
                try {
                    sueldo = Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                    contador = 2;
                }
            } else if(contador==4){
                int ee = 0;
                try {
                    ee = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                    contador = 3;
                }
                if(ee==1) recibida = true;
                else if (ee==2) {
                    recibida = false;
                    sueldo = sueldo / 2;
                }
                else{
                    System.out.println("Entrada invalida");
                    contador = 3;
                }
            }

            contador++;
        }

        System.out.println("Para finalizar el registro, asigná a "+apellido+", "+nombre+" a uno de los sgtes. salones:");

        try {
            Thread.sleep(3269);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sl.imprimirSalasRegistradas();

        int seleccion = -2;
        while (seleccion == -2) {
            Scanner s = new Scanner(System.in);

            try {
                seleccion = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if (seleccion <= -2) {
                continue;
            } else if (seleccion == -1) System.exit(0);

            sl.asignarMaestraASala(legajo, seleccion);
            System.out.println(apellido+", "+nombre+" fue registrada con exito");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isRecibida() {
        return recibida;
    }

    public void setRecibida(boolean recibida) {
        this.recibida = recibida;
    }
}
