package actividad2209;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SalasDisponibles {
    private int lactarios = 0;
    private int deambulador1 = 0;
    private int deambulador2 = 0;
    private int sala2 = 0;
    private int sala3 = 0;
    private final List<Sala> salas = new ArrayList<>();

    public boolean haySalones() {
        return (lactarios + deambulador1 + deambulador2 + sala2 + sala3 == 0);
    }

    public void imprimirSalasRegistradas() {
        for (Sala sala : salas) {
            System.out.println(salas.indexOf(sala)+")"+sala.getTipoDeSala());
        }
    }

    public boolean asignarMaestraASala(int dni, int salaSeleccionada){
        if (salas.get(salaSeleccionada) == null) {
            System.out.println("La sala seleccionada no existe, por favor reintentá.");
            return false;
        }

        return salas.get(salaSeleccionada).agregarMaestra(dni);
    }

    public void registrarLactarios() {
        System.out.println("Ingrese la cantidad los lactarios disponibles para hoy:");
        int numero = 0;
        while (numero==0){
            Scanner s = new Scanner(System.in);
            try {
                numero = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(numero ==-1) {
                System.out.println("Saliendo...");
                System.exit(0);
            } else if(numero < -1){
                System.out.println("Entrada invalida");
                numero = 0;
            } else{
                this.lactarios = numero;
                for (int i = 0; i < numero; i++) {
                    Sala sala = new Sala();
                    sala.setTipoDeSala(Sala.TipoDeSala.LACTORIO);
                    salas.add(sala);
                }
                System.out.println("Se registraron: "+numero+" lactarios");
                break;
            }
        }
    }

    public void registrarDeambuladores1() {
        System.out.println("Ingrese la cantidad los Deambuladores (tipo 1) disponibles para hoy:");
        int numero = 0;
        while (numero==0){
            Scanner s = new Scanner(System.in);
            try {
                numero = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(numero ==-1) {
                System.out.println("Saliendo...");
                System.exit(0);
            } else if(numero < -1){
                System.out.println("Entrada invalida");
                numero = 0;
            } else{
                this.deambulador1 = numero;
                System.out.println("Se registraron: "+numero+" Deambuladores tipo 1");
                break;
            }
        }
    }

    public void registrarDeambuladores2() {
        System.out.println("Ingrese la cantidad de Deambuladores (tipo 2) disponibles para hoy:");
        int numero = 0;
        while (numero==0){
            Scanner s = new Scanner(System.in);
            try {
                numero = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(numero ==-1) {
                System.out.println("Saliendo...");
                System.exit(0);
            } else if(numero < -1){
                System.out.println("Entrada invalida");
                System.out.println("Opciones disponibles:");
                System.out.println("1) Agregar alumno");
                System.out.println("-1 Salir de este programa.");
                numero = 0;
            } else{
                this.deambulador2 = numero;
                System.out.println("Se registraron: "+numero+" Deambuladores tipo 2");
                break;
            }
        }
    }

    public void registrarSalas2() {
        System.out.println("Ingrese la cantidad de Salas (tipo 2) disponibles para hoy:");
        int numero = 0;
        while (numero==0){
            Scanner s = new Scanner(System.in);
            try {
                numero = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(numero ==-1) {
                System.out.println("Saliendo...");
                break;
            } else if(numero < -1){
                System.out.println("Entrada invalida");
                System.out.println("Opciones disponibles:");
                System.out.println("1) Agregar alumno");
                System.out.println("-1 Salir de este programa.");
                numero = 0;
            } else{
                this.sala2 = numero;
                System.out.println("Se registraron: "+numero+" Salas tipo 2");
                break;
            }
        }
    }

    public void registrarSalas3() {
        System.out.println("Ingrese la cantidad de Deambuladores (tipo 3) disponibles para hoy:");
        int numero = 0;
        while (numero==0){
            Scanner s = new Scanner(System.in);
            try {
                numero = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
            }

            if(numero ==-1) {
                System.out.println("Saliendo...");
                System.exit(0);
            } else if(numero < -1){
                System.out.println("Entrada invalida");
                System.out.println("Opciones disponibles:");
                System.out.println("1) Agregar alumno");
                System.out.println("-1 Salir de este programa.");
                numero = 0;
            } else{
                this.sala3 = numero;
                System.out.println("Se registraron: "+numero+" Salas tipo 3");
                break;
            }
        }
    }

    public boolean getLactarios() {
        return (lactarios == 0);
    }

    public void setLactarios() {
        this.lactarios -= 1;
    }

    public boolean getDeambulador1() {
        return (deambulador1 == 0);
    }

    public void setDeambulador1() {
        this.deambulador1 -= 1;
    }

    public boolean getDeambulador2() {
        return (deambulador2 == 0);
    }

    public void setDeambulador2() {
        this.deambulador2 -= 1;
    }

    public boolean getSala2() {
        return (sala2 == 0);
    }

    public void setSala2() {
        this.sala2 -= 1;
    }

    public boolean getSala3() {
        return (sala3 == 0);
    }

    public void setSala3() {
        this.sala3 -= 1;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}
