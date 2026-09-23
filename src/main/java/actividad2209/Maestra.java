package actividad2209;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Maestra {
    private String nombre;
    private String apellido;
    private int legajo;
    private double sueldo;

    public void registrarYAsignarASalon(SalasDisponibles sl){
        String entrada = "";
        int contador = 0;
        while (contador <= 3) {
            Scanner s = new Scanner(System.in);

            if (contador == 0) {
                System.out.println("Ingresa el nombre de la Maestra:");
            } else if (contador == 1) {
                System.out.println("Ingresa el apellido de la Maestra:");
            } else if (contador == 2) {
                System.out.println("Ingresa el DNI (sin puntos) de la Maestra:");
            } else if (contador == 3) {
                System.out.println("Ingresa el sueldo (sin puntos ni comas) de la Maestra:");
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
            } else if (contador == 3) {
                try {
                    sueldo = Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida");
                    contador = 2;
                }
            }

            contador++;
        }
        System.out.println(apellido+", "+nombre+" fue registrada con exito");
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
}
